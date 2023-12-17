


    var mensagem = /*[[${mensagem}]]*/ "";
    console.log("Mensagem recebida:", mensagem);
    if (mensagem.trim() !== "") {
        alert(mensagem);
        window.location.href = '/pageCadastroNivel';  // Altere conforme necessário
    }
