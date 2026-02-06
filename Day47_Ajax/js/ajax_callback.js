const XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

function makeAjaxCall(method, url, callback) {

  const xhr = new XMLHttpRequest();

  xhr.open(method, url, true);

  xhr.onreadystatechange = function () {

    if (xhr.readyState === 4) {

      if (xhr.status >= 200 && xhr.status < 300) {
        callback(null, xhr.responseText);
      } else {
        callback("Error Occurred", null);
      }
    }
  };

  xhr.send();
}


/************* CALL *************/
makeAjaxCall(
  "GET",
  "http://localhost:3000/employees",
  function (err, data) {

    if (err) {
      console.log(err);
    } else {
      console.log(JSON.parse(data));
    }

  }
);
