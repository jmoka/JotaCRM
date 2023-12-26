



function opcaoPretoBranco(opcao) {
	console.log(opcao + " opção");
    var pretoBranco = document.getElementById('pretoBranco');
    var estiloPreto = document.getElementById('estiloPreto');
    var estiloBranco = document.getElementById('estiloBranco');
	pretoBranco.checked = opcao
    // Verifica se o switch checkbox está marcado ou não
   

    if (!opcao) {
        estiloPreto.removeAttribute('disabled');
        estiloBranco.setAttribute('disabled', 'true');
    } else {
        estiloBranco.removeAttribute('disabled');
        estiloPreto.setAttribute('disabled', 'true');
    }

    // Chama a função pretoBranco() para realizar ações adicionais se necessário
    pretoBranco();
}


function obterPropertiesStyle() {
    $(document).ready(function() {
        // Use Ajax para chamar o endpoint do servidor
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8081/obterPropertiesStyle',  // Atualize com o URL correto do seu servidor
            dataType: 'text',
            success: function(data) {
                // Converte a string para um valor booleano
                var opcao = data.toLowerCase() === 'true';  
                
                // Chama a função opcaoPretoBranco com o valor booleano
                opcaoPretoBranco(opcao);
            },
            error: function(error) {
                console.error('Erro:', error);
            }
        });
    });
}

document.addEventListener("DOMContentLoaded", function () {
   
    obterPropertiesStyle();
});

   