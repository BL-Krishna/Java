const XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

function makeAjaxCall(method, url) {

  return new Promise((resolve, reject) => {

    const xhr = new XMLHttpRequest();

    xhr.open(method, url, true);

    xhr.onload = () => {
      if (xhr.status >= 200 && xhr.status < 300)
        resolve(xhr.responseText);
      else
        reject(xhr.statusText);
    };

    xhr.onerror = () => reject("Network Error");

    xhr.send();
  });
}


/************* CALL *************/
makeAjaxCall("GET", "http://localhost:3000/employees")
  .then(data => console.log(JSON.parse(data)))
  .catch(err => console.log(err));
