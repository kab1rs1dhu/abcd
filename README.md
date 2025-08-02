# Love Message Website

A special website created with love, featuring password protection, heart animations, and a photo slideshow.

## Local Development

To run the application locally:

```bash
./mvnw spring-boot:run
```

Then access the application at http://localhost:8080

## Deploying to Render

### Method 1: Manual Deployment

1. Create a new Web Service on Render
2. Connect your GitHub repository
3. Choose "Docker" as the environment
4. Use the default Dockerfile settings
5. Set the following environment variables:
   - `SPRING_PROFILES_ACTIVE=prod`
6. Deploy the service

### Method 2: Using render.yaml (Recommended)

1. Push your code to GitHub with the included `render.yaml` file
2. In Render dashboard, go to "Blueprints" section
3. Connect your GitHub repository
4. Render will automatically detect the `render.yaml` file and set up the service
5. Click "Apply" to deploy

## Features

- Password-protected access
- Beautiful pink theme
- Heart animations
- Photo slideshow with fullscreen mode
- Mobile-optimized design
- Upload new photos 