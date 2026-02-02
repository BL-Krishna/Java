let employees = [];
let editIndex = null;

const table = document.getElementById("employeeTable");
const formView = document.getElementById("formView");
const listView = document.getElementById("listView");
const form = document.getElementById("employeeForm");

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

form.addEventListener("submit", function (e) {
  e.preventDefault();

  const name = document.getElementById("name").value;
  const gender = document.querySelector('input[name="gender"]:checked').value;
  const salary = document.getElementById("salary").value;
  const startDate = document.getElementById("startDate").value;

  const departments = [...document.querySelectorAll('.checkboxes input:checked')]
    .map(d => d.value);

  const employee = { name, gender, departments, salary, startDate };

  if (editIndex !== null) {
    employees[editIndex] = employee;
  } else {
    employees.push(employee);
  }

  renderTable();
  showList();
});

function renderTable() {
  table.innerHTML = "";

  employees.forEach((emp, index) => {
    const row = document.createElement("tr");

    row.innerHTML = `
      <td>${emp.name}</td>
      <td>${emp.gender}</td>
      <td>${emp.departments.map(d => `<span class="badge">${d}</span>`).join("")}</td>
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

function editEmployee(index) {
  const emp = employees[index];
  editIndex = index;

  document.getElementById("name").value = emp.name;
  document.getElementById("salary").value = emp.salary;
  document.getElementById("startDate").value = emp.startDate;

  document.querySelector(`input[name="gender"][value="${emp.gender}"]`).checked = true;

  document.querySelectorAll(".checkboxes input").forEach(c => {
    c.checked = emp.departments.includes(c.value);
  });

  showForm();
}

function deleteEmployee(index) {
  employees.splice(index, 1);
  renderTable();
}
