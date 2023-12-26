function pretoBranco() {
    // Obtém o elemento do switch checkbox pelo ID
    var pretoBranco = document.getElementById('pretoBranco');
    var estiloPreto = document.getElementById('estiloPreto');
    var estiloBranco = document.getElementById('estiloBranco');

    // Verifica se o switch checkbox está marcado ou não
    var checked = pretoBranco.checked ? "Preto" : "Branco";

    if (checked == "Preto") {
        estiloPreto.removeAttribute('disabled');
        estiloBranco.setAttribute('disabled', 'true');
    } else {
        estiloBranco.removeAttribute('disabled');
        estiloPreto.setAttribute('disabled', 'true');
    }

    
    // Exibe a informação em um alerta (você pode manipular a informação como desejar)
    alert('O switch checkbox está ' + checked);
}
