# sor-api (Smart Order Routing API)

금융 및 커머스 환경에서 대용량 주문의 접수, 상태 검증, 라우팅 및 라이프사이클 관리를 수행하는 Spring Boot 기반의 코어 백엔드 API 시스템입니다.

## Tech Stack
* **Language**: Java 17
* **Framework**: Spring Boot, Spring Data JPA
* **Database**: H2 Database
* **Build Tool**: Maven

## Key Features
- **주문 라이프사이클 관리**: 주문 접수('RECEIVED'), 검증('VALIDATED'), 라우팅('ROUTED'), 체결 완료('COMPLETED'), 거절('REJECTED') 상태 머신 구현
- **RESTful API 설계**: 클라이언트(대시보드) 연동을 위한 표준화된 JSON 응답 인터페이스 제공

---

## Architecture & Design
- **Entity & DTO 분리**: 데이터베이스 영속성 계층과 API 응답 계층을 분리하여 시스템 유지보수성 향상
