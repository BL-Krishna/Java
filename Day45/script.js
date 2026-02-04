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
  set name(v) { this._name = v; }

  get avatar() { return this._avatar; }
  set avatar(v) { this._avatar = v; }

  get gender() { return this._gender; }
  set gender(v) { this._gender = v; }

  get departments() { return this._departments; }
  set departments(v) { this._departments = v; }

  get salary() { return this._salary; }
  set salary(v) { this._salary = v; }

  get startDate() { return this._startDate; }
  set startDate(v) { this._startDate = v; }

  get notes() { return this._notes; }
  set notes(v) { this._notes = v; }
}


/*************** GLOBAL DATA (UC6 – LocalStorage) ***************/
let employees = JSON.parse(localStorage.getItem("EmployeePayrollList")) || [];
let editIndex = null;

const table = document.getElementById("employeeTable");
const formView = document.getElementById("formView");
const listView = document.getElementById("listView");
const form = document.getElementById("employeeForm");


/*************** UC 3 + UC 4 – DOMContentLoaded ***************/
window.addEventListener("DOMContentLoaded", () => {
  updateEmployeeCount();
  renderTable();
});


/*************** HEADER COUNT (UC6) ***************/
function updateEmployeeCount() {
  document.getElementById("empCount").textContent = employees.length;
}


/*************** VIEW SWITCH ***************/
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
  const regex = /^[A-Z][a-z]{2,}$/;
  return regex.test(document.getElementById("name").value);
}

function validateDate() {
  const date = new Date(document.getElementById("startDate").value);
  return date <= new Date();
}


/*************** UC 3 – CREATE OBJECT ON SAVE ***************/
form.addEventListener("submit", function (e) {
  e.preventDefault();

  if (!validateName() || !validateDate()) {
    alert("Invalid Name or Date");
    return;
  }

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


  /*************** UC 4 – Save to LocalStorage ***************/
  localStorage.setItem("EmployeePayrollList", JSON.stringify(employees));

  updateEmployeeCount();
  renderTable();
  showList();
});


/*************** UC 3/4/5 – TEMPLATE LITERALS TABLE ***************/
function renderTable() {

  let html = "";

  for (let i = 0; i < employees.length; i++) {

    const emp = employees[i];

    html += `
      <tr>
        <td>${emp._avatar} ${emp._name}</td>
        <td>${emp._gender}</td>
        <td>
          ${(emp._departments || [])
            .map(dep => `<span class="badge">${dep}</span>`)
            .join("")}
        </td>
        <td>₹ ${emp._salary}</td>
        <td>${emp._startDate}</td>
        <td>
          <button onclick="editEmployee(${i})">✏️</button>
          <button onclick="deleteEmployee(${i})">🗑️</button>
        </td>
      </tr>
    `;
  }

  table.innerHTML = html;
}


/*************** EDIT ***************/
function editEmployee(index) {
  const emp = employees[index];
  editIndex = index;

  document.getElementById("name").value = emp._name;
  document.getElementById("salary").value = emp._salary;
  document.getElementById("startDate").value = emp._startDate;
  document.querySelector("textarea").value = emp._notes;

  document.querySelector(`input[name="gender"][value="${emp._gender}"]`).checked = true;
  document.querySelector(`input[name="avatar"][value="${emp._avatar}"]`).checked = true;

  document.querySelectorAll(".checkboxes input").forEach(c => {
    c.checked = (emp._departments || []).includes(c.value);
  });

  showForm();
}


/*************** DELETE ***************/
function deleteEmployee(index) {
  employees.splice(index, 1);
  localStorage.setItem("EmployeePayrollList", JSON.stringify(employees));
  updateEmployeeCount();
  renderTable();
}


/*************** RESET ***************/
form.addEventListener("reset", () => editIndex = null);
