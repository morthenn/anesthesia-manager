const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {patients: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/api/patients'}).done(response => {
			this.setState({patients: response.entity._embedded.patients});
		});
	}

	render() {
		return (
			PatientList patients={this.state.patients}
		)
	}
}