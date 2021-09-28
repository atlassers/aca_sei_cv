class FilmService {
	constructor() { }

	static getAll() {
		BaseService.getAll('/films/v1')
			.then(function(filmDtoList) {
				var content = '<table class="aca-fill">';
				content += '<tr>'
					+ '<th scope="col">Id</th>'
					+ '<th scope="col">Title</th>'
					+ '<th scope="col">Director</th>'
					+ '</tr>';
				jQuery.each(filmDtoList, function(i, val) {
					content += '<tr>'
						+ '<td>' + val.id + '</td>'
						+ '<td>' + val.title + '</td>'
						+ '<td>' + val.director + '</td>'
						+ '<td><button id="btnDetail-' + val.id + '" class="btn btn-warning" onclick="FilmService.detail(' + val.id + ')">detail</button></td>'
						+ '<td><button id="btnDelete-' + val.id + '" class="btn btn-danger" onclick="FilmService.delete(' + val.id + ')">delete</button></td>'
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
		BaseService.post('/films/v1', formData)
			.then(function(filmDto) {
				$('#saveForm').trigger('reset');
				$('#saveForm').hide();

				FilmService.getAll();
			});
	}

	static put(formData) {
		BaseService.put('/films/v1', formData)
			.then(function(filmDto){
				window.alert("Film updated")
				$('#saveForm').trigger('reset');
				$('#saveForm').hide();

				FilmService.getAll();
			});
	}

	static delete(id) {
		BaseService.delete('/films/v1', id)
			.then(function(result) {
				window.alert('Film ' + id + ' deleted!')

				FilmService.getAll();
			});
	}


	static detail(id) {
		BaseService.get('/films/v1', id)
			.then(function(filmDto) {
				document.getElementById('id').value = filmDto.id;
				document.getElementById('director').value = filmDto.title;
				document.getElementById('director').value = filmDto.director;

				$('.table').empty();
				$('.table').hide();
				$('#saveForm').show();
			});
	}
}