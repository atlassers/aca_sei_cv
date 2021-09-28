$(document).ready(function() {
	$('#btnShow').click(function() {
		CinemaRoomService.getAll();
	});

	$('#btnAdd').click(function() {
		$('table').empty();
		$('table').hide();
		$('#saveForm').show();
	})

	$('#saveForm').submit(function(event) {
		event.preventDefault();

		var id = document.getElementById('id').value;
		var seats = document.getElementById('seats').value;

		var formData = JSON.stringify({
			'id': id ? id : null,
			'seats': seats
		})

		if (id) {
			CinemaRoomService.put(formData);
		} else {
			CinemaRoomService.post(formData);
		}		
	});	
});