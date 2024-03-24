# mastering-criteria-query

Project to test and improve the way of handling dynamic filtering from a request.

There is a service endpoint: [POST] /api/v1/dogs/search which handle filtering from several fields defined in the body.

Example: 

Calling the endpoint by POST method: localhost:8080/api/v1/dogs/search and specifying body: {"name" : "luna"} the backend will search all the dogs by name "luna".

[
    {
        "id": 2,
        "name": "Luna",
        "breed": "Border Collie",
        "birthday": "2020-02-15",
        "color": "White and Black",
        "vaccinated": true
    },
    {
        "id": 3,
        "name": "Luna",
        "breed": "Pastor Aleman",
        "birthday": "2020-02-15",
        "color": "White and Black",
        "vaccinated": true
    }
]


Calling the endpoint by POST method: localhost:8080/api/v1/dogs/search and specifying body: {"name" : "luna","breed" : "Pastor Aleman"} the backend will search all the dogs by name "luna" AND breed "Pastor Aleman".

{
        "id": 3,
        "name": "Luna",
        "breed": "Pastor Aleman",
        "birthday": "2020-02-15",
        "color": "White and Black",
        "vaccinated": true
}

The pojo for filtering is DogSearchFilterDto so you can filter by any field defined in this class.
