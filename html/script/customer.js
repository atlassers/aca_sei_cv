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
		var name = document.getElementById('name').value;
		var filmId = document.getElementById('filmId').value;
		var cinemaRoomId = document.getElementById('cinemaRoomId')
		var formData = JSON.stringify({
			'id': id ? id : null,
			'name': name,
			'filmId' : filmId,
			'cinemaRoomId' : cinemaRoomId
		})

		if (id) {
			FilmService.put(formData);
		} else {
			FilmService.post(formData);
		}		
	});	
});