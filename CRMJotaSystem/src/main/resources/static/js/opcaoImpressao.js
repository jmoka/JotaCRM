// Corrija a referência da variável para "opcaoImpressao"
function gerarRelatorioNivel() {
	var opcaoConsulta = document.getElementById('opcaoConsulta').value;
	var opcaoImpressao = document.getElementById('opcaoImpressao').value;
	var opcaoOrdem = document.getElementById('opcaoOrdem').value;
	
	
	console.log(opcaoConsulta);
	console.log(opcaoImpressao );
	console.log(opcaoOrdem);
	
	

	if (opcaoConsulta == "1" && opcaoImpressao == "1" && opcaoOrdem == "1") {
		console.log("1 1 1 ");
		window.location.href = "/relatorioNivelTodosTelaPorId";

	}
	
	
	if (opcaoConsulta == "1" && opcaoImpressao == "1" && opcaoOrdem == "2") {
		console.log("1 1 2 ");
		window.location.href = "/relatorioNivelTodosTelaNome";

	}
	
	
	
	

	if (opcaoConsulta == "1" && opcaoImpressao == "2" && opcaoOrdem == "2") {
		console.log("1 2");
		window.location.href = "/relatorioNivelTodosPDF";
		
	}

	if (opcaoConsulta == "1" && opcaoImpressao == "3" && opcaoOrdem == "2" ) {
		console.log("1 3");
		window.location.href = "/relatorioNivelTodosHTML";
		
		
	}


	if (opcaoConsulta == "2" && opcaoImpressao == "1") {
		console.log("2 1");


    // Seleciona o modal e atribui o ID
    const myModal = document.getElementById('myModal');
    myModal.setAttribute('data-idNivel', idNivel);

    // Exibe o modal
    const bootstrapModal = new bootstrap.Modal(myModal);
    bootstrapModal.show();
    

	}

	if (opcaoConsulta == "2" && opcaoImpressao == "2") {
		console.log("2 2 ");
	}

	if (opcaoConsulta == "2" && opcaoImpressao == "3") {
		console.log("2 3 ");
	}

	if (opcaoConsulta == "3" && opcaoImpressao == "1") {
		console.log("3 1 ");
	}

	if (opcaoConsulta == "3" && opcaoImpressao == "2") {
		console.log("3 2 ");
	}

	if (opcaoConsulta == "3" && opcaoImpressao == "3") {
		console.log("3 3 ");
	}
	
}
