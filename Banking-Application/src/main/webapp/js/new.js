
function handleFormSubmission(event) {
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
			return response.text();
		})
		.then(data => {
			document.getElementById('content-section').innerHTML = data;
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
            document.getElementById('content-section').innerHTML = data;
            attachFormSubmissionHandler(); // Attach handler to any newly loaded forms
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}
// Event listener for navigation links
document.querySelectorAll('nav a').forEach(link => {
	link.addEventListener('click', event => {
		event.preventDefault();
		const page = event.target.getAttribute('data-page');
		fetchAndAppendContent(page);
	});
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

// Initial setup on DOMContentLoaded
document.addEventListener('DOMContentLoaded', () => {
	attachFormSubmissionHandler(); // Attach handler to any forms in the initial content
});
