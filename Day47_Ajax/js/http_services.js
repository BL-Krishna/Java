function makeServiceCall(method, url) {

  return new Promise((resolve, reject) => {

    const xhr = new XMLHttpRequest();

    xhr.open(method, url);

    xhr.onload = () => resolve(xhr.responseText);

    xhr.onerror = () => reject("Failed");

    xhr.send();
  });
}
