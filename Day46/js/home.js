window.addEventListener("DOMContentLoaded", loadTable);

function loadTable(){
  const list = getEmployees();
  document.getElementById("empCount").textContent = list.length;

  let html="";

  list.forEach(emp=>{
    html += `
      <tr>
        <td>${emp._name}</td>
        <td>${emp._gender}</td>
        <td>${emp._departments.map(d=>`<span class="badge">${d}</span>`).join("")}</td>
        <td>₹ ${emp._salary}</td>
        <td>${emp._startDate}</td>
        <td>
          <button onclick="edit(${emp._id})">✏️</button>
          <button onclick="removeEmp(${emp._id})">🗑️</button>
        </td>
      </tr>
    `;
  });

  document.getElementById("employeeTable").innerHTML = html;
}

function edit(id){
  localStorage.setItem("editId", id);
  window.location="payroll_form.html";
}

function removeEmp(id){
  deleteById(id);
  loadTable();
}
