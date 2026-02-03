/*************** UC 1 – Employee Payroll Class ***************/
class EmployeePayroll {
  constructor() {
    this._name = "";
    this._avatar = "";
    this._gender = "";
    this._departments = [];
    this._salary = "";
    this._startDate = "";
    this._notes = "";
  }

  get name() { return this._name; }
  set name(value) { this._name = value; }

  get avatar() { return this._avatar; }
  set avatar(value) { this._avatar = value; }

  get gender() { return this._gender; }
  set gender(value) { this._gender = value; }

  get departments() { return this._departments; }
  set departments(value) { this._departments = value; }

  get salary() { return this._salary; }
  set salary(value) { this._salary = value; }

  get startDate() { return this._startDate; }
  set startDate(value) { this._startDate = value; }

  get notes() { return this._notes; }
  set notes(value) { this._notes = value; }
}

/*************** GLOBAL STATE ***************/
let employees = JSON.parse(localStorage.getItem("EmployeePayrollList")) || [];
let editIndex = null;

const table = document.getElementById("employeeTable");
const formView = document.getElementById("formView");
const listView = document.getElementById("listView");
const form = document.getElementById("employeeForm");

/*************** UC 2 – On Document Load ***************/
window.addEventListener("DOMContentLoaded", () => {
  renderTable();
  document.getElementById("name").addEventListener("input", validateName);
  document.getElementById("startDate").addEventListener("change", validateDate);
});

/*************** VIEW TOGGLING ***************/
function showForm() {
  listView.classList.add("hidden");
  formView.classList.remove("hidden");
}

function showList() {
  formView.classList.add("hidden");
  listView.classList.remove("hidden");
  form.reset();
  editIndex = null;
}

/*************** VALIDATIONS ***************/
function validateName() {
  const name = document.getElementById("name").value;
  const regex = /^[A-Z][a-z]{2,}$/;
  if (!regex.test(name)) {
    alert("Name must start with capital letter and have minimum 3 characters");
    return false;
  }
  return true;
}

function validateDate() {
  const startDate = new Date(document.getElementById("startDate").value);
  if (startDate > new Date()) {
    alert("Start date cannot be in the future");
    return false;
  }
  return true;
}

/*************** UC 3 – CREATE EMPLOYEE ***************/
form.addEventListener("submit", function (e) {
  e.preventDefault();
  if (!validateName() || !validateDate()) return;

  const emp = new EmployeePayroll();
  emp.name = document.getElementById("name").value;
  emp.avatar = document.querySelector('input[name="avatar"]:checked').value;
  emp.gender = document.querySelector('input[name="gender"]:checked').value;
  emp.salary = document.getElementById("salary").value;
  emp.startDate = document.getElementById("startDate").value;
  emp.notes = document.querySelector("textarea").value;

  emp.departments = [...document.querySelectorAll(".checkboxes input:checked")]
    .map(d => d.value);

  if (editIndex !== null) employees[editIndex] = emp;
  else employees.push(emp);

  localStorage.setItem("EmployeePayrollList", JSON.stringify(employees));
  renderTable();
  showList();
});

/*************** RENDER TABLE ***************/
function renderTable() {
  table.innerHTML = "";

  employees.forEach((emp, index) => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${emp.avatar || ""} ${emp.name}</td>
      <td>${emp.gender}</td>
      <td>${(emp.departments || []).map(d => `<span class="badge">${d}</span>`).join("")}</td>
      <td>₹ ${emp.salary}</td>
      <td>${emp.startDate}</td>
      <td>
        <button onclick="editEmployee(${index})">✏️</button>
        <button onclick="deleteEmployee(${index})">🗑️</button>
      </td>
    `;
    table.appendChild(row);
  });
}

/*************** EDIT ***************/
function editEmployee(index) {
  const emp = employees[index];
  editIndex = index;

  document.getElementById("name").value = emp.name;
  document.getElementById("salary").value = emp.salary;
  document.getElementById("startDate").value = emp.startDate;
  document.querySelector("textarea").value = emp.notes || "";

  document.querySelector(`input[name="gender"][value="${emp.gender}"]`).checked = true;
  document.querySelector(`input[name="avatar"][value="${emp.avatar}"]`).checked = true;

  document.querySelectorAll(".checkboxes input").forEach(c => {
    c.checked = (emp.departments || []).includes(c.value);
  });

  showForm();
}

/*************** DELETE ***************/
function deleteEmployee(index) {
  employees.splice(index, 1);
  localStorage.setItem("EmployeePayrollList", JSON.stringify(employees));
  renderTable();
}

/*************** UC 5 – RESET ***************/
form.addEventListener("reset", () => editIndex = null);
