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

  if (!validateForm()) {
    console.log(validateForm());
    return false;
  }

  let student = {
    id: Date.now(),
    name: document.getElementById("fname").value,
    surname: document.getElementById("lname").value,
    personal_identification_code: document.getElementById("identificationCode")
      .value,
    gender: document.getElementById("male").checked ? "male" : "female",
    address: document.getElementById("address").value,
    phone: document.getElementById("phone").value,
    program: document.getElementById("program").value,
    form_of_studies: document.getElementById("regular").checked
      ? "regular"
      : "online",
  };

  // Checks if there is a student with same personal id code
  if (!search(student.personal_identification_code, students)) {
    students.push(student);
  } else {
    alert("Student with this personal id already exists");
    return false;
  }

  // students.push(student);
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


// Checks whether personal id code is valid
function checkPersonalID() {
  var personal_identification_code_last_chr = personal_identification_code.value.charAt(
    10
  );

  // check the formule
  var C =
    personal_identification_code.value.charAt(0) * 1 +
    personal_identification_code.value.charAt(1) * 2 +
    personal_identification_code.value.charAt(2) * 3 +
    personal_identification_code.value.charAt(3) * 4 +
    personal_identification_code.value.charAt(4) * 5 +
    personal_identification_code.value.charAt(5) * 6 +
    personal_identification_code.value.charAt(6) * 7 +
    personal_identification_code.value.charAt(7) * 8 +
    personal_identification_code.value.charAt(8) * 9 +
    personal_identification_code.value.charAt(9) * 1;

    // then divide C by 11
  C = C % 11;

  // if remainder is equal to 10, then new sum with coefficients is calculated
  if (C >= 10) {
    var S =
      personal_identification_code.value.charAt(0) * 3 +
      personal_identification_code.value.charAt(1) * 4 +
      personal_identification_code.value.charAt(2) * 5 +
      personal_identification_code.value.charAt(3) * 6 +
      personal_identification_code.value.charAt(4) * 7 +
      personal_identification_code.value.charAt(5) * 8 +
      personal_identification_code.value.charAt(6) * 9 +
      personal_identification_code.value.charAt(7) * 1 +
      personal_identification_code.value.charAt(8) * 2 +
      personal_identification_code.value.charAt(9) * 3;

      // and then divided by 11 again
    S = S % 11;

    // if remainder is not equal to 10, then check checksum S
    if (S !== 10) {
      return personal_identification_code_last_chr == S;
    } else {
      return personal_identification_code_last_chr == 0;
    }
  } else {
    return personal_identification_code_last_chr == C;
  }
}

// Checks if gender coincides with the one in the personal id code
function verifyGender() {
  gender_selected = document.querySelector('input[name="gender"]:checked')
    ?.value;
  if (gender_selected == "male") {
    if (
      personal_identification_code.value.charAt(0) == 1 ||
      personal_identification_code.value.charAt(0) == 3 ||
      personal_identification_code.value.charAt(0) == 5
    ) {
      return true;
    } else {
      return false;
    }
  }
  if (gender_selected == "female") {
    if (
      personal_identification_code.value.charAt(0) == 2 ||
      personal_identification_code.value.charAt(0) == 4 ||
      personal_identification_code.value.charAt(0) == 6
    ) {
      return true;
    } else {
      return false;
    }
  }
}

// Searches given array for a value
function search(nameKey, myArray) {
  for (var i = 0; i < myArray.length; i++) {
    if (myArray[i].personal_identification_code === nameKey) {
      return true;
    }
  }
}

// function validateForm() {
//   // add values to consts and trim white space
//   const nameValue = name.value;
//   const surnameValue = surname.value;
//   const personalIDValue = personal_identification_code.value;
//   const genderValue = gender.value;
//   // const genderValue = document.querySelector('input[name="gender"]:checked')?.value;
//   const addressValue = address.value;
//   const phoneValue = phone.value;
//   const programValue = program.value;
//   const formOfStudiesValue = form_of_studies.value;

//   if (nameValue === "") {
//     setErrorFor(name, "Name cannot be empty");
//     return false;
//   } else {
//     setSuccessFor(name);
//   }

//   if (surnameValue === "") {
//     setErrorFor(surname, "Surname cannot be empty");
//     return false;
//   } else {
//     setSuccessFor(surname);
//   }

//   if (personalIDValue === "") {
//     setErrorFor(personal_identification_code, "Personal ID cannot be empty");
//     return false;
//   } else {
//     if (checkPersonalID()) {
//       setSuccessFor(personal_identification_code);
//     } else {
//       setErrorFor(personal_identification_code, "Invalid personal identification code")
//       return false;
//     }
//   }

//   // genderValue = document.querySelector('input[name="gender"]:checked')?.value
//   // gender_selected = document.getElementById("gender")?.value
//   gender_selected = document.querySelector('input[name="gender"]:checked')?.value
//   if (gender_selected == undefined) {
//     gender.style.color = "red";
//     // alert("Select gender");
//     // setErrorFor(gender, "Select gender")
//     // return false;
//   } else {
//     if (verifyGender()) {
//       // setSuccessFor(gender);
//       gender.style.color = "green";
//     } else {
//       gender.style.color = "red";
//       setErrorFor(personal_identification_code, "Gender does not match with personal ID")
//       // alert("Selected gender doesn't match personal id code");
//       return false;
//     }
//   }

//   if (addressValue == "") {
//     setErrorFor(address, "Address cannot be empty");
//     return false;
//   } else {
//     setSuccessFor(address);
//   }

//   if (phoneValue == "") {
//     setErrorFor(phone, "Phone cannot be empty");
//     return false;
//   } else {
//     setSuccessFor(phone);
//   }

//   if (programValue == "") {
//     setErrorFor(program, "Program must be selected");
//     return false;
//   } else {
//     setSuccessFor(program);
//   }

//   return true;
// }


function validateForm() {
  function validateName()
}
  // add values to consts and trim white space
  const nameValue = name.value;
  const surnameValue = surname.value;
  const personalIDValue = personal_identification_code.value;
  const genderValue = gender.value;
  // const genderValue = document.querySelector('input[name="gender"]:checked')?.value;
  const addressValue = address.value;
  const phoneValue = phone.value;
  const programValue = program.value;
  const formOfStudiesValue = form_of_studies.value;

  if (nameValue === "") {
    setErrorFor(name, "Name cannot be empty");
    return false;
  } else {
    setSuccessFor(name);
  }

  if (surnameValue === "") {
    setErrorFor(surname, "Surname cannot be empty");
    return false;
  } else {
    setSuccessFor(surname);
  }

  if (personalIDValue === "") {
    setErrorFor(personal_identification_code, "Personal ID cannot be empty");
    return false;
  } else {
    if (checkPersonalID()) {
      setSuccessFor(personal_identification_code);
    } else {
      setErrorFor(personal_identification_code, "Invalid personal identification code")
      return false;
    }
  }

  // genderValue = document.querySelector('input[name="gender"]:checked')?.value
  // gender_selected = document.getElementById("gender")?.value
  gender_selected = document.querySelector('input[name="gender"]:checked')?.value
  if (gender_selected == undefined) {
    gender.style.color = "red";
    // alert("Select gender");
    // setErrorFor(gender, "Select gender")
    // return false;
  } else {
    if (verifyGender()) {
      // setSuccessFor(gender);
      gender.style.color = "green";
    } else {
      gender.style.color = "red";
      setErrorFor(personal_identification_code, "Gender does not match with personal ID")
      // alert("Selected gender doesn't match personal id code");
      return false;
    }
  }

  if (addressValue == "") {
    setErrorFor(address, "Address cannot be empty");
    return false;
  } else {
    setSuccessFor(address);
  }

  if (phoneValue == "") {
    setErrorFor(phone, "Phone cannot be empty");
    return false;
  } else {
    setSuccessFor(phone);
  }

  if (programValue == "") {
    setErrorFor(program, "Program must be selected");
    return false;
  } else {
    setSuccessFor(program);
  }

  return true;
}

function setErrorFor(input, message) {
  const formControl = input.parentElement; // .form-control
  const small = formControl.querySelector("small"); // target small inside form controll

  // add error message inside small
  small.innerText = message;

  // add error class
  formControl.className = "form-control error";
  return false
}

function setSuccessFor(input) {
  const formControl = input.parentElement;
  formControl.className = "form-control success";
}