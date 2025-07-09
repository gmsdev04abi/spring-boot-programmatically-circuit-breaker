# WireMock Docker Setup

This project includes a Docker Compose configuration for running WireMock with predefined API mappings.

## Available Mock APIs

1. **Success API (200 Status)**
   - Endpoint: `GET /api/success`
   - Returns a 200 status with sample JSON data

2. **Error API (500 Status)**
   - Endpoint: `GET /api/error`
   - Returns a 500 status with error details

## Running WireMock

To start the WireMock server:

```bash
docker-compose up
```

The WireMock server will be available at http://localhost:8080

## Testing the APIs

You can test the mock APIs using curl:

```bash
# Test the success API
curl http://localhost:8080/api/success

# Test the error API
curl http://localhost:8080/api/error
```

## Adding More Mappings

To add more API mappings, create JSON files in the `wiremock/mappings` directory following the WireMock format.
