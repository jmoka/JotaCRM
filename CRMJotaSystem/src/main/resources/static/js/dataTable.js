$(document).ready(function () {
			console.log('Script DataTables sendo executado...');
			$('#dt-filter-select').DataTable({
				initComplete: function () {
					this.api().columns().every(function () {
						var column = this;
						var select = $('<select class="browser-default custom-select form-control-sm"><option value="" selected>Buscar</option></select>')
							.appendTo($(column.footer()).empty())
							.on('change', function () {
								var val = $.fn.dataTable.util.escapeRegex($(this).val());

								column
									.search(val ? '^' + val + '$' : '', true, false)
									.draw();
							});

						column.data().unique().sort().each(function (d, j) {
							select.append('<option value="' + d + '">' + d + '</option>');
						});
					});
				}
			});
		});