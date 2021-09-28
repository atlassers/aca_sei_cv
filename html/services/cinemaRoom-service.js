class CinemaRoomService {
	constructor() { }

	static getAll() {
		BaseService.getAll('/cinema-rooms/v1')
			.then(function(cinemaRoomDtoList) {
				var content = '<table class="aca-fill">';
				content += '<tr>'
					+ '<th scope="col">Id</th>'
					+ '<th scope="col">Seats</th>'
					+ '</tr>';
				jQuery.each(cinemaRoomDtoList, function(i, val) {
					content += '<tr>'
						+ '<td>' + val.id + '</td>'
						+ '<td>' + val.seats + '</td>'
						+ '<td><button id="btnDetail-' + val.id + '" class="btn btn-warning" onclick="CinemaRoomService.detail(' + val.id + ')">detail</button></td>'
						+ '<td><button id="btnDelete-' + val.id + '" class="btn btn-danger" onclick="CinemaRoomService.delete(' + val.id + ')">delete</button></td>'
						+ '</tr>';
				});
				content += '</table>';

				$('#saveForm').trigger('reset');
				$('#saveForm').hide();
				$('.table').empty();
				$('.table').append(content);
				$('.table').show();
			});
	}

	static post(formData) {
		BaseService.post('/cinema-rooms/v1', formData)
			.then(function(cinemaRoomDto) {
				$('#saveForm').trigger('reset');
				$('#saveForm').hide();

				CinemaRoomService.getAll();
			});
	}

	static put(formData) {
		BaseService.put('/cinema-rooms/v1', formData)
			.then(function(cinemaRoomDto){
				window.alert("La sala è stata aggiornata")
				$('#saveForm').trigger('reset');
				$('#saveForm').hide();

				CinemaRoomService.getAll();
			});
	}

	static delete(id) {
		BaseService.delete('/cinema-rooms/v1', id)
			.then(function(result) {
				window.alert('CinemaRoom ' + id + ' deleted!')

				CinemaRoomService.getAll();
			});
	}


	static detail(id) {
		BaseService.get('/cinema-rooms/v1', id)
			.then(function(cinemaRoomDto) {
				document.getElementById('id').value = cinemaRoomDto.id;
				document.getElementById('seats').value = cinemaRoomDto.seats;
				$('.table').empty();
				$('.table').hide();
				$('#saveForm').show();
			});
	}
}