const modalCaminhoRelatorio = new bootstrap.Modal(document.getElementById('modalCaminhoRelatorio'));
const myInput = document.getElementById('idNivelRelatorio');

modalCaminhoRelatorio.show();

modalCaminhoRelatorio.addEventListener('shown.bs.modal', () => {
	myInput.focus();
});



