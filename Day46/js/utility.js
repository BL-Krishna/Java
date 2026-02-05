function getEmployees(){
  return JSON.parse(localStorage.getItem("EmployeePayrollList")) || [];
}

function saveEmployees(list){
  localStorage.setItem("EmployeePayrollList", JSON.stringify(list));
}

function getById(id){
  return getEmployees().find(e => e._id == id);
}

function deleteById(id){
  let list = getEmployees();
  list = list.filter(e => e._id != id);
  saveEmployees(list);
}
