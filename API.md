## Unsecured Route
These routes do not require a valid JWT token in the request `Authorization` header
### POST FORMDATA /api/v1/authenticate
Required params:
* `username`
* `password`

Returns status:
* `200` - Successful authentication with JWT user token in response header
* `401` - Authentication failure

### POST JSON /api/v1/user
Required params:
```json
{
    "username": "username",
    "password": "passord"
}
```

Return status:
* `201` - User created
```json
{
    "id": 1,
    "username": "username",
    "authorities": [
        {
            "authority": "ROLE_USER"
        }
    ],
    "accountNonExpired": true,
    "accountNonLocked": true,
    "credentialsNonExpired": true,
    "enabled": true
}
```
* `400` - User with username already exists
* `401` - Authentication failure

## Secured Routes
### GET /api/v1/todo
Returns all the todos of the current user

Required params: `None`

Returns status:
* `200` - Returned all todo listing for current user
```json
[
    {
        "id": 1,
        "content": "Todo 1",
        "createdDate": "2019-06-16T11:29:36.837+0000",
        "updatedDate": "2019-06-16T11:29:36.837+0000"
    },
    {
        "id": 2,
        "content": "Todo 2",
        "createdDate": "2019-06-16T11:29:36.838+0000",
        "updatedDate": "2019-06-16T11:29:36.838+0000"
    }
]
```
* `401` - Authentication failure


### POST JSON /api/v1/todo
Creates a todo for the current user
Required params:
```json
{
	"contents": "Posted todo"
}
```

Returns status:
* `201` - Todo created
```json
{
    "id": 1,
    "content": "Posted todo",
    "createdDate": "2019-06-16T21:35:03.738+0000",
    "updatedDate": "2019-06-16T21:35:03.738+0000"
}
```
* `401` - Authentication failure

### PUT JSON /api/v1/todo/:id
Updates a todo of id if owned by the current user
Required params:
* `id`
```json
{
	"contents": "Updated todo"
}
```

Returns status:
* `202` - Todo Updated
```json
{
    "id": 1,
    "content": "Updated todo",
    "createdDate": "2019-06-16T21:35:03.738+0000",
    "updatedDate": "2019-06-16T21:35:03.738+0000"
}
```
* `401` - Authentication failure
* `404` - Todo not found

### DELETE /api/v1/todo/:id
Deletes a todo of id if owned by the current user

Required params:
* `id`

Returns status:
* `200` - Todo deleted
* `401` - Authentication failure
* `404` - Todo not found

### GET /api/v1/todo/search/:searchString
Searches todo contents of current user and returns matching todos

Required params: 
* `searchString` - Todo content string to search

Returns status:
* `200` - Returned all todo listing for current user
```json
[
    {
        "id": 1,
        "content": "Todo 1",
        "createdDate": "2019-06-16T11:29:36.837+0000",
        "updatedDate": "2019-06-16T11:29:36.837+0000"
    }
]
```
* `401` - Authentication failure