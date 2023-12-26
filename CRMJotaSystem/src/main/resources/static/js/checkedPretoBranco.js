



function opcaoPretoBranco(opcao) {
    var pretoBranco = document.getElementById('pretoBranco');
    var estiloPreto = document.getElementById('estiloPreto');
    var estiloBranco = document.getElementById('estiloBranco');
	pretoBranco.checked = opcao
    // Verifica se o switch checkbox está marcado ou não
    var checked = pretoBranco.checked;

    if (!checked) {
        estiloPreto.removeAttribute('disabled');
        estiloBranco.setAttribute('disabled', 'true');
    } else {
        estiloBranco.removeAttribute('disabled');
        estiloPreto.setAttribute('disabled', 'true');
    }

    // Chama a função pretoBranco() para realizar ações adicionais se necessário
    pretoBranco();
}

document.addEventListener("DOMContentLoaded", function () {
    opcaoPretoBranco();
});