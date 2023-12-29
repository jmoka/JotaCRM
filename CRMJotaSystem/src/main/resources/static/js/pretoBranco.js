function pretoBranco() {
    var pretoBranco = document.getElementById('pretoBranco');
    var estiloPreto = document.getElementById('estiloPreto');
    var estiloBranco = document.getElementById('estiloBranco');

    // Verifica se o switch checkbox está marcado ou não
    var checked = pretoBranco.checked;
    

    if (!checked) {
        estiloPreto.removeAttribute('disabled');
        estiloBranco.setAttribute('disabled', 'true');
    } else {
        estiloBranco.removeAttribute('disabled');
        estiloPreto.setAttribute('disabled', 'true');
    }

    
    // Use AJAX para enviar a opção ao servidor
    $.ajax({
        type: 'POST',
        url: '/atualizarStyle',
        data: { opcao: checked },
        success: function(response) {
            // Lida com a resposta do servidor, se necessário
        },
        error: function(error) {
            console.error('Erro na solicitação AJAX:', error);
        }
    });
}
   
 
   