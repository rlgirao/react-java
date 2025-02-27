FROM node:22-alpine3.21 AS builder

WORKDIR /teste-embracon
COPY package.json package-lock.json /teste-embracon/

RUN npm install

COPY ./ /teste-embracon

RUN npm run build

RUN ls -la /teste-embracon/dist

FROM nginx:1.27.3-alpine

COPY nginx.conf /etc/nginx/nginx.conf

COPY --from=builder /teste-embracon/dist/ /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]