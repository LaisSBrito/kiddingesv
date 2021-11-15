/**
 *Validação de formulario 
 */

function validar(){
	let nome = cadastro.nome.value
	let email = cadastro.email.value
	let senha = cadastro.senha.value
	let senha2 = cadastro.senha2.value
	if (nome === "") {
		alert('Preencha todos os campos')
		cadastro.nome.focus()
		return false
	}
	 else if (email === "") {
		alert('Preencha todos os campos') 
		cadastro.email.focus()
		return false
	} 
	 else if (senha === "") {
		alert('Preencha todos os campos') 
		cadastro.senha.focus()
		return false
	} 
	 else if (senha2 === "") {
		alert('Preencha todos os campos') 
		cadastro.senha2.focus()
		return false			
	} 
	 if (senha !== senha2) {
		alert('Senhas diferentes') 
		cadastro.senha2.focus()
		return false
	}
	 else { Document.forms["cadastro"].submit
	}
}
