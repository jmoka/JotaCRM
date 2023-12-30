// Function to block the opcaoOrdem select element
function bloquearOpcaoOrdem() {
    var opcaoConsulta = document.getElementById('opcaoConsulta');
    var opcaoOrdem = document.getElementById('opcaoOrdem');
    
    if(opcaoConsulta.value === '1') { 
		
		 opcaoOrdem.disabled = false;
		 }

    if (opcaoConsulta.value === '2') {
       
        opcaoOrdem.disabled = true;
    
    }
        
    if(opcaoConsulta.value === '3') { 
		
          opcaoOrdem.disabled = true;
          }
          
    if(opcaoConsulta.value === '4') { 
		
          opcaoOrdem.disabled = true;
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
