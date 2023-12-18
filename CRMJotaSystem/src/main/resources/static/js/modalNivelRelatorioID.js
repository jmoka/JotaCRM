const myModal = document.getElementById('myModal');
const idNivelSpan = document.getElementById('idNivelSpan');

myModal.addEventListener('shown.bs.modal', () => {
    const idNivel = myModal.getAttribute('data-idNivel');
    idNivelSpan.textContent = idNivel;
});
