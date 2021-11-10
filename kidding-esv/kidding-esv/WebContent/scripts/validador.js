/**
 *Validação de formulario 
 */

function validar(){
	let nome = cadastro.nome.value
	let email = cadastro.email.value
	if (nome === "") {
		alert('Preencha este campo')
		cadastro.nome.focus()
		return false
	} else if (email === "") {
		alert('Preencha este campo')
		cadastro.nome.focus() 
		cadastro.email.focus()
		return false
	} else Document.forms["cadastro"].submit
}


