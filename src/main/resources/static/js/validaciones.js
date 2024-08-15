// Validation del formulario de login
document.querySelector('.form.login').addEventListener('submit', function(event) {
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!email || !emailRegex.test(email)) {
        alert('Por favor ingrese un email válido.');
        event.preventDefault();
        return;
    }

    if (!password) {
        alert('Por favor ingrese su contraseña.');
        event.preventDefault();
        return;
    }
});

// Validación del formulario de registro
document.querySelector('.form.register').addEventListener('submit', function(event) {
    const nombre = document.getElementById('nombre').value;
    const email2 = document.getElementById('email2').value;
    const password2 = document.getElementById('password2').value;
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!nombre) {
        alert('Por favor ingrese su nombre.');
        event.preventDefault();
        return;
    }

    if (!email2 || !emailRegex.test(email2)) {
        alert('Por favor ingrese un email válido.');
        event.preventDefault();
        return;
    }

    if (!password2) {
        alert('Por favor ingrese una contraseña.');
        event.preventDefault();
        return;
    }

    if (password2.length < 6) {
        alert('La contraseña debe tener al menos 6 caracteres.');
        event.preventDefault();
        return;
    }
});

// Cambio entre formularios (login y registro)
document.getElementById('sing-in').addEventListener('click', function(event) {
    event.preventDefault();
    document.querySelector('.form.login').classList.add('hide');
    document.querySelector('.form.register').classList.remove('hide');
});

document.getElementById('sing-up').addEventListener('click', function(event) {
    event.preventDefault();
    document.querySelector('.form.register').classList.add('hide');
    document.querySelector('.form.login').classList.remove('hide');
});
