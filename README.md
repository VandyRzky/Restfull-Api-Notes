# Api Specification

## Note Specification

### Register Note
- Endpoint: POST /api/notes
- Request body:
```json
{
  "title": "Title",
  "content": "content"
}
```
- Response Body (Success):
```json
{
  "data": {
    "id": "id note",
    "title": "title",
    "content": "content",
    "created at": "date"
  }
}
```
- Response Body (Failed):
```json
{
  "data": null,
  "error": "Error: {error message}"
}
```
### Get All Notes
- Endpoint: Get /api/notes
- Response Body (Success):
```json
{
  "data": [
    {
    "id": "id note",
    "title": "title",
    "content": "content",
    "created at": "date"
  },
    {
      "id": "id note2",
      "title": "title2",
      "content": "content2",
      "created at": "date2"
    }
  ]
}
```
- Response Body (Failed):
```json
{
  "data": null,
  "error": "Error: {error message}"
}
```
### Get Note
- Endpoint: Get /api/notes/{id}
- Response Body (Success):
```json
{
  "data": 
    {
    "id": "id note",
    "title": "title",
    "content": "content",
    "created at": "date"
  }
}
```
- Response Body (Failed):
```json
{
  "data": null,
  "error": "Error: {error message}"
}
```
### Update Note
- Endpoint: PATCH /api/notes/{id}
- Request body:
```json
{
  "title": "Title",
  "content": "content"
}
```
- Response Body (Success):
```json
{
  "data": {
    "id": "id note",
    "title": "title",
    "content": "content",
    "created at": "date",
    "updated at": "date"
  }
}
```
- Response Body (Failed):
```json
{
  "data": null,
  "error": "Error: {error message}"
}
```
### Delete Note
- Endpoint: DELETE /api/notes/{id}
- Response Body (Success):
```json
{
  "data": "Delete Success",
  "error": null
}
```
- Response Body (Failed):
```json
{
  "data": null,
  "error": "Error: {error message}"
}
```