// Function to block the opcaoOrdem select element
function bloquearOpcaoOrdem() {
    var opcaoConsulta = document.getElementById('opcaoConsulta');
    var opcaoOrdem = document.getElementById('opcaoOrdem');

    // Check if the selected value is "2"
    if (opcaoConsulta.value === '2') {
        // Disable the opcaoOrdem select element
        opcaoOrdem.disabled = true;
    } else if(opcaoConsulta.value === '1') { 
		 opcaoOrdem.disabled = false;
	}else{
        // Enable the opcaoOrdem select element
        opcaoOrdem.disabled = false;
    }
}

// Function to enable the opcaoOrdem select element
function liberarOpcaoOrdem() {
    var opcaoOrdem = document.getElementById('opcaoOrdem');
    
    // Enable the opcaoOrdem select element
    opcaoOrdem.disabled = false;
}

// Attach the bloquearOpcaoOrdem function to the change event of opcaoConsulta
document.getElementById('opcaoConsulta').addEventListener('change', bloquearOpcaoOrdem);
