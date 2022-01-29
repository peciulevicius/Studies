const form = document.getElementById("form");
const name = document.getElementById("fname");
const surname = document.getElementById("lname");
const personal_identification_code = document.getElementById(
  "identificationCode"
);
const gender = document.getElementById("gender");
const address = document.getElementById("address");
const phone = document.getElementById("phone");
const program = document.getElementById("program");
const form_of_studies = document.getElementById("formOfStudies");

let students = [];

const addStudent = (e) => {
  e.preventDefault(); // to stop the form from submitting
    
    let student = {
      id: Date.now(),
      name: document.getElementById("fname").value,
      surname: document.getElementById("lname").value,
      personal_identification_code: document.getElementById(
        "identificationCode"
        ).value,
      gender: document.getElementById("male").checked ? "male" : "female",
      address: document.getElementById("address").value,
      phone: document.getElementById("phone").value,
      program: document.getElementById("program").value,
      form_of_studies: document.getElementById("regular").checked
      ? "regular"
      : "online",
    };
    
    students.push(student);
    document.forms[0].reset(); // clear form
    // document.querySelector('form').reset()
    
    console.log("added", { students });
    let pre = document.querySelector("#msg pre");
    pre.textContent = "\n" + JSON.stringify(students, "\t", 2);

    // saving to local storage (can find local storage in Application -> local storage)
    localStorage.setItem("StudentList", JSON.stringify(students));
};

document.addEventListener("DOMContentLoaded", () => {
  document.getElementById("btn").addEventListener("click", addStudent);
});
