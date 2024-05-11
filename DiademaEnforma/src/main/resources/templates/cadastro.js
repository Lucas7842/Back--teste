let btn = document.querySelector('#verSenha')
let btnConfirm = document.querySelector('#verConfirmSenha')


let nome = document.querySelector('#nome')
let labelNome = document.querySelector('#labelNome')
let validNome = false

let nomeprofissional = document.querySelector('#nomeprofissional')
let labelNomeProfissional = document.querySelector('#labelNomeProfissional')
let validNomeProfissional = false

let cnpj = document.querySelector('#cnpj')
let labelCnpj = document.querySelector('#labelCnpj')
let validCnpj = false

let areadeatuacao = document.querySelector('#areadeatuacao')
let labelAreaDeAtuacao = document.querySelector('#labelAreaDeAtuacao')
let validAreaDeAtuacao = false

let dataNascimento = document.querySelector('#dataNascimento')
let labelDataNascimento = document.querySelector('#labelDataNascimento')
let validDataNascimento = false


let email = document.querySelector('#email')
let labelEmail = document.querySelector('#labelEmail')
let validEmail = false



let telefone = document.querySelector('#telefone')
let labelTelefone = document.querySelector('#labelTelefone')
let validTelefone = false

let senha = document.querySelector('#senha')
let labelSenha = document.querySelector('#labelSenha')
let validSenha = false

let confirmSenha = document.querySelector('#confirmSenha')
let labelConfirmSenha = document.querySelector('#labelConfirmSenha')
let validConfirmSenha = false

let msgError = document.querySelector('#msgError')
let msgSuccess = document.querySelector('#msgSuccess')

nome.addEventListener('keyup', () => {
if (nome.value.length <= 2) {
labelNome.setAttribute('style', 'color: red')
labelNome.innerHTML = 'Nome *Insira no minimo 3 caracteres'
nome.setAttribute('style', 'border-color: red')
validNome = false
} else {
labelNome.setAttribute('style', 'color: green')
labelNome.innerHTML = 'Nome'
nome.setAttribute('style', 'border-color: green')
validNome = true
}
})

areadeatuacao.addEventListener('keyup', () => {
if (areadeatuacao.value.length <= 2) {
labelAreaDeAtuacao.setAttribute('style', 'color: red')
labelAreaDeAtuacao.innerHTML = 'Área de Atuação *Insira no minimo 5 caracteres'
areadeatuacao.setAttribute('style', 'border-color: red')
validAreaDeAtuacao = false
}
else {
labelAreaDeAtuacao.setAttribute('style', 'color: green')
labelAreaDeAtuacao.innerHTML = 'Área de Atuação'
areadeatuacao.setAttribute('style', 'border-color: green')
validAreaDeAtuacao = true

}
})

nomeprofissional.addEventListener('keyup', () => {
if (nomeprofissional.value.length <= 2) {
labelNomeProfissional.setAttribute('style', 'color: red')
labelNomeProfissional.innerHTML = 'Nome *Insira no minimo 3 caracteres'
nomeprofissional.setAttribute('style', 'border-color: red')
validNomeProfissional = false

} else {
labelNomeProfissional.setAttribute('style', 'color: green')
labelNomeProfissional.innerHTML = 'Nome'
nomeprofissional.setAttribute('style', 'border-color: green')
validNomeProfissional = true

}
})

email.addEventListener('keyup', () => {
if (email.value.length <= 6){
labelEmail.setAttribute('style', 'color: red')
labelEmail.innerHTML = 'Email *Insira um email válido no maximo 10 caracteris '
email.setAttribute('style', 'border-color: red')
validEmail = false
} else {
labelEmail.setAttribute('style', 'color: green')
labelEmail.innerHTML = 'Email'
email.setAttribute('style', 'border-color: green')
validEmail = true
}
})

cnpj.addEventListener('keyup', () => {
if (cnpj.value.length <= 4) {
labelCnpj.setAttribute('style', 'color: red')
labelCnpj.innerHTML = 'Usuário *Insira no minimo 5 caracteres'
cnpj.setAttribute('style', 'border-color: red')
validCnpj = false
} else {
labelUsuario.setAttribute('style', 'color: green')
labelUsuario.innerHTML = 'Usuário'
usuario.setAttribute('style', 'border-color: green')
validUsuario = true
}
})

telefone.addEventListener('keyup', () => {
if (telefone.value.length < 10) {
labelTelefone.setAttribute('style', 'color: red')
labelTelefone.innerHTML = 'Telefone *Insira um telefone válido'
telefone.setAttribute('style', 'border-color: red')
validTelefone = false
} else {
labelTelefone.setAttribute('style', 'color: green')
labelTelefone.innerHTML = 'Telefone'
telefone.setAttribute('style', 'border-color: green')
validTelefone = true
}
})

senha.addEventListener('keyup', () => {
if (senha.value.length <= 5) {
labelSenha.setAttribute('style', 'color: red')
labelSenha.innerHTML = 'Senha *Insira no minimo 6 caracteres'
senha.setAttribute('style', 'border-color: red')
validSenha = false
} else {
labelSenha.setAttribute('style', 'color: green')
labelSenha.innerHTML = 'Senha'
senha.setAttribute('style', 'border-color: green')
validSenha = true
}
})

confirmSenha.addEventListener('keyup', () => {
if (senha.value != confirmSenha.value) {
labelConfirmSenha.setAttribute('style', 'color: red')
labelConfirmSenha.innerHTML = 'Confirmar Senha *As senhas não conferem'
confirmSenha.setAttribute('style', 'border-color: red')
validConfirmSenha = false
} else {
labelConfirmSenha.setAttribute('style', 'color: green')
labelConfirmSenha.innerHTML = 'Confirmar Senha'
confirmSenha.setAttribute('style', 'border-color: green')
validConfirmSenha = true
}
})

function cadastrar() {
if (validNome && validUsuario && validSenha && validConfirmSenha) {
let listaUser = JSON.parse(localStorage.getItem('listaUser') || '[]')

listaUser.push(
{
nomeCad: nome.value,
userCad: usuario.value,
senhaCad: senha.value
}
)

localStorage.setItem('listaUser', JSON.stringify(listaUser))


msgSuccess.setAttribute('style', 'display: block')
msgSuccess.innerHTML = '<strong>Cadastrando usuário...</strong>'
msgError.setAttribute('style', 'display: none')
msgError.innerHTML = ''

setTimeout(() => {
window.location.href = 'https://cdpn.io/thicode/debug/ZELzYxV/dXAqBaRyvwJk'
}, 3000)


} else {
msgError.setAttribute('style', 'display: block')
msgError.innerHTML = '<strong>Preencha todos os campos corretamente antes de cadastrar</strong>'
msgSuccess.innerHTML = ''
msgSuccess.setAttribute('style', 'display: none')
}
}

btn.addEventListener('click', () => {
let inputSenha = document.querySelector('#senha')

if (inputSenha.getAttribute('type') == 'password') {
inputSenha.setAttribute('type', 'text')
} else {
inputSenha.setAttribute('type', 'password')
}
})

btnConfirm.addEventListener('click', () => {
let inputConfirmSenha = document.querySelector('#confirmSenha')

if (inputConfirmSenha.getAttribute('type') == 'password') {
inputConfirmSenha.setAttribute('type', 'text')
} else {
inputConfirmSenha.setAttribute('type', 'password')
}
})
