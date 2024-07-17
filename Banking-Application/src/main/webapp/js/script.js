
function handleFormSubmission(event) {
	var loader = document.getElementById('loader');
	loader.style.display = 'inline-block';
	event.preventDefault();
	const form = event.target;
	const formData = new FormData(form);
	const action = form.getAttribute('action');
	const method = form.getAttribute('method');
	const searchParams = new URLSearchParams();
	for (const pair of formData) {
		searchParams.append(pair[0], pair[1]);
	}

	fetch(action, {
		method: method,
		body: searchParams
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			loader.style.display = 'none';
			return response.text();
		})
		.then(data => {
			document.getElementById('service').innerHTML = data;
			attachFormSubmissionHandler(); // Attach handler to any newly loaded forms
		})
		.catch(error => {
			console.error('Error:', error);
		});

}


function submitForm() {
	const form = document.getElementById('myForm');
	const formData = new FormData(form);
	const searchParams = new URLSearchParams();
	for (const pair of formData) {
		searchParams.append(pair[0], pair[1]);
	}

	fetch('CreateAccount', {
		method: 'POST',
		body: searchParams
	})
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.text();
		})
		.then(data => {
			console.log(data); // Log server response for debugging
			// Optionally, update the page with any response data
		})
		.catch(error => {
			console.error('Error:', error);
		});
}
function fetchAndAppendContent(page) {
	fetch(page)
		.then(response => {
			if (!response.ok) {
				throw new Error('Network response was not ok');
			}
			return response.text();
		})
		.then(data => {
			document.getElementById('service').innerHTML = data;
			attachFormSubmissionHandler(); // Attach handler to any newly loaded forms
		})
		.catch(error => {
			console.error('There was a problem with the fetch operation:', error);
		});
}

// Event listener for navigation links
document.querySelectorAll('nav a').forEach(link => {
	link.addEventListener('click', event => {
		document.getElementById('aboutSection').style.display = 'none';
		document.getElementById('content-section').style.display = 'flex';
		document.getElementById('aboutUs').classList.remove('active');

		event.preventDefault();
		const page = event.target.getAttribute('data-page');
		fetchAndAppendContent(page);
	});
});
//Event listner for service section 
document.querySelectorAll('.services li > a').forEach(link => {
	link.addEventListener('click', event => {
		document.getElementById('aboutSection').style.display = 'none';
		document.getElementById('content-section').style.display = 'flex';
		document.getElementById('aboutUs').classList.remove('active');


		event.preventDefault();
		const page = event.target.getAttribute('data-page');
		fetchAndAppendContent(page);
	});
});

//Event listner on about page
document.getElementById('aboutUs').addEventListener('click', event => {
	event.preventDefault();
	document.getElementById('aboutUs').classList.add('active');
	var about = document.getElementById('aboutSection');
	var content = document.getElementById('content-section');
	about.style.display = 'flex';
	content.style.display = 'none';
	about.setAttribute('stage', 'active');
});

// Attach form submission handler
function attachFormSubmissionHandler() {
	const forms = document.querySelectorAll('form');
	forms.forEach(form => {
		form.addEventListener('submit', event => {
			handleFormSubmission(event);
		});
	});
}

