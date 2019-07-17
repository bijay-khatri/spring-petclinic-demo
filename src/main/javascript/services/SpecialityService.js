let baseUri = 'http://localhost:8080/api'; //TODO: Will read it from external config
const SpecialityService = {
    getSpecialities: () => fetch(`${baseUri}/specialities`)
        .then(res => res.json())
        .then(res => res.map(r => {
            return {
                id: r.id,
                name: r.name,
                checked: false
            }
        }))
        .catch(error => console.error)// Log it to central logstash
}

export default SpecialityService;
