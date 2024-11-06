let slider = document.querySelector('.slider');
let choices = document.querySelectorAll('.opt');
let container = document.querySelector('.maincontainer');
let right = document.querySelector('.rightside');
let left = document.querySelector('.leftcontent');
let back = document.querySelector('#back');

const doctorEmail = 'doctor@gmail.com';
const doctorPass = "12345";

const paitentEmail = "paitent@gmail.com";
const paitentPass = "12345";

const pharmEmail = "pharm@gmail.com";
const pharmPass = "12345";

document.querySelector('.email_pass').addEventListener('submit', function (e){
    e.preventDefault();
    const email = document.querySelector('.email_input').value.trim();
    const password = document.querySelector('.pass_input').value.trim();
    let isValid = true;
    console.log("Email input:", email);

    document.querySelectorAll('.error-message').forEach(msg => msg.remove());

    if(email !== doctorEmail && email !== paitentEmail && email !== pharmEmail){
        showError('#email_holder');
        isValid = false; 
    }

    if(email == ""){
        showBlankError('#email_holder');
        isValid = false;
    }

    if(password !== doctorPass || password !== paitentPass || password !== pharmPass){
        showPassError('#password');
        isValid = false; 
    }
    if(password == ""){
        showPassBlank('#password');
    }

    if(isValid){
        console.log(email);
        showSuccess();
    }
})

function showSuccess(){
    const modal = document.createElement('div');
    modal.classList.add('success');
    modal.style.display = 'flex';
    modal.style.position = 'absolute';

    modal.innerHTML = `<div class = "modal"> 
                        <h2> Login Successful </h2>
                        <button id = "backSelect"> Back to Login Page </button>
                        </div>`;

    document.body.appendChild(modal);

    document.getElementById('backSelect').addEventListener('click', function (){
        modal.remove();
        document.querySelector('.email_pass').reset();
    });
}

function showError(inputSelector){
    const message = "The email you have input is incorrect";
    const inputElement = document.querySelector(inputSelector);
    const error = document.createElement('div');
    error.classList.add('error-message');
    error.style.color = 'red';
    error.innerText = message;
    inputElement.parentNode.appendChild(error);   
}

function showBlankError(inputSelector){
    const message = "The email cannot be blank";
    const inputElement = document.querySelector(inputSelector);
    const error = document.createElement('div');
    error.classList.add('error-message');
    error.style.color = 'red';
    error.innerText = message;
    inputElement.parentNode.appendChild(error);

}

function showPassError(inputSelector){
    const message = "The password you have input is incorrect";
    const inputElement = document.querySelector(inputSelector);
    const error = document.createElement('div');
    error.classList.add('error-message');
    error.style.color = 'red';
    error.innerText = message;
    inputElement.parentNode.appendChild(error);

}

function showPassBlank(inputSelector){
    const message = "The password cannot be blank";
    const inputElement = document.querySelector(inputSelector);
    const error = document.createElement('div');
    error.classList.add('error-message');
    error.style.color = 'red';
    error.innerText = message;
    inputElement.parentNode.appendChild(error);

}
    


choices.forEach(button => {
    button.addEventListener('click', () =>{
        if(button.getAttribute('type') !== 'submit') {
            let type =  button.getAttribute('id');
            slider.classList.toggle('active');
            console.log(type);
            changeBackground(type);
            left.classList.toggle('invis');
            right.classList.toggle('visible');
        }
       
    })

});

back.addEventListener('click', () =>{
    slider.classList.toggle('active');
    left.classList.toggle('invis');
    right.classList.toggle('visible');

    slider.style.backgroundColor = '#fcdede';
    container.style.backgroundColor = '#fcdede';
    document.querySelectorAll('.error-message').forEach(msg => msg.remove());
});

function changeBackground(choice){
    if (choice === 'doctor'){
        slider.style.backgroundColor = '#dbdaff';
        container.style.backgroundColor = '#dbdaff';
    }
    else if (choice === 'pharmacist'){
        slider.style.backgroundColor = '#e9c1f6';
        container.style.backgroundColor = '#e9c1f6';
    }

    else if (choice === 'paitent'){
        slider.style.backgroundColor = '#c3ffd6';
        container.style.backgroundColor = '#c3ffd6';
    }    
}
