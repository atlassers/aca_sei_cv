$(document).ready(function() {
	$('#btnShow').click(function() {
		FilmService.getAll();
	});

	$('#btnAdd').click(function() {
		$('table').empty();
		$('table').hide();
		$('#saveForm').show();
	})

	$('#saveForm').submit(function(event) {
		event.preventDefault();

		var id = document.getElementById('id').value;
		var title = document.getElementById('title').value;
		var director = document.getElementById('director').value;
		var formData = JSON.stringify({
			'id': id ? id : null,
			'title': title,
			'director' : director
		})

		if (id) {
			FilmService.put(formData);
		} else {
			FilmService.post(formData);
		}		
	});	
});