const form = document.getElementById("empForm");
const editId = localStorage.getItem("editId");


if (editId) {
  const emp = getById(editId);

  document.getElementById("name").value = emp._name;
  document.getElementById("salary").value = emp._salary;
  document.getElementById("startDate").value = emp._startDate;
  document.getElementById("notes").value = emp._notes;

  document.querySelector(`input[name="gender"][value="${emp._gender}"]`).checked = true;

  document.querySelectorAll('input[type="checkbox"]').forEach(c => {
    c.checked = emp._departments.includes(c.value);
  });
}


form.addEventListener("submit", function (e) {
  e.preventDefault();

  const nameInput = document.getElementById("name");
  const salaryInput = document.getElementById("salary");
  const startDateInput = document.getElementById("startDate");
  const notesInput = document.getElementById("notes");

  const genderInput = document.querySelector('input[name="gender"]:checked');

  if (!genderInput) {
    alert("Please select Gender");
    return;
  }

  const emp = new EmployeePayroll();

  emp._name = nameInput.value;
  emp._gender = genderInput.value;
  emp._salary = salaryInput.value;
  emp._startDate = startDateInput.value;
  emp._notes = notesInput.value;

  emp._departments = [...document.querySelectorAll('input[type="checkbox"]:checked')]
    .map(c => c.value);


  /******** DATE VALIDATION ********/
  const selectedDate = new Date(emp._startDate);
  const today = new Date();

  if (selectedDate > today) {
    alert("Start date cannot be future");
    return;
  }


  /******** SAVE ********/
  let list = getEmployees();

  if (editId) {
    // update existing
    const index = list.findIndex(e => e._id == editId);
    emp._id = editId;
    list[index] = emp;
  } else {
    // new employee
    list.push(emp);
  }

  saveEmployees(list);
  localStorage.removeItem("editId");

  window.location = "index.html";
});
