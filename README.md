# 

## 1. Eventstorming Model
![exam-1](https://github.com/hossun/food-delivery-exam/assets/8733715/eae04f1e-55d9-4596-b197-c6cf24fcf5a7)

## 2. Saga (Pub / Sub) 확인
![exam-2](https://github.com/hossun/food-delivery-exam/assets/8733715/0f2b34be-6844-4086-9719-c75f6c12d2a4)

## 3. Service Router 설치
**router Pod**

![exam-3-1](https://github.com/hossun/food-delivery-exam/assets/8733715/7f0b9e0d-99aa-40dd-b2e4-040373e1005e)


**router service**

![exam-3-2](https://github.com/hossun/food-delivery-exam/assets/8733715/4b500983-b1df-4367-a328-50e91aa13b55)

**router 정보**
```
spring:
  profiles: docker
  cloud:
    gateway:
      routes:
        - id: front
          uri: http://front:8080
          predicates:
            - Path=/orders/**, /payments/**, 
        - id: store
          uri: http://store:8080
          predicates:
            - Path=/storeOrders/**, 
        - id: delivery
          uri: http://delivery:8080
          predicates:
            - Path=/dekeveries/**, 
        - id: summary
          uri: http://summary:8080
          predicates:
            - Path=/alertLogs/**, 
        - id: frontend
          uri: http://frontend:8080
          predicates:
            - Path=/**
      globalcors:
        corsConfigurations:
          '[/**]':
            allowedOrigins:
              - "*"
            allowedMethods:
              - "*"
            allowedHeaders:
              - "*"
            allowCredentials: true

server:
  port: 8080
  ```

## 4. Zero downtime Deployment
### Zero Downtime 적용 안한 Case
#### yaml 파일
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: front
  labels:
    app: front
spec:
  replicas: 1
  selector:
    matchLabels:
      app: front
  template:
    metadata:
      labels:
        app: front
    spec:
      containers:
        - name: front
          image: hossun/exam-front:v1.1
          ports:
            - containerPort: 8080
```
#### siege 로그
![exam-4-1](https://github.com/hossun/food-delivery-exam/assets/8733715/cefcff9e-906b-4464-8b4b-5fb99480a826)

![exam-4-2](https://github.com/hossun/food-delivery-exam/assets/8733715/3b6e7f29-9e39-4e54-b596-0f9f1f73f1a4)





###
```

apiVersion: apps/v1
kind: Deployment
metadata:
  name: front
  labels:
    app: front
spec:
  replicas: 1
  selector:
    matchLabels:
      app: front
  template:
    metadata:
      labels:
        app: front
    spec:
      containers:
        - name: front
          image: hossun/exam-front:v1.0.1
          ports:
            - containerPort: 8080
          readinessProbe:
            httpGet:
              path: '/actuator/health'
              port: 8080
            initialDelaySeconds: 10
            timeoutSeconds: 2
            periodSeconds: 5
            failureThreshold: 10
          livenessProbe:
            httpGet:
              path: '/actuator/health'
              port: 8080
            initialDelaySeconds: 120
            timeoutSeconds: 2
            periodSeconds: 5
            failureThreshold: 5
```            


