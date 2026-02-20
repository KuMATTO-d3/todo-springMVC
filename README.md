# Todo Application

## Overview

Spring Boot を用いて構築した Todo 管理アプリケーションです。

本プロジェクトは単なるCRUD実装ではなく、  
**レイヤー分割設計・責務分離・拡張性を意識した構成の実践** を目的としています。

将来的な REST API 化やフロントエンド分離（SPA化）を見据え、
ドメインモデルと外部I/Fモデル（DTO）を分離する設計を採用しています。

---

## Purpose

- Spring MVC の理解深化
- JPA による永続化設計
- レイヤー分割アーキテクチャの実践
- 将来拡張を見据えた構造設計の検証
- 設計ドキュメント作成を含めた開発プロセスの訓練

---

## Tech Stack

- Java 17
- Spring Boot 3.x
- Spring MVC
- Spring Data JPA
- Thymeleaf
- H2 Database
- Gradle

---

## Architecture

本アプリケーションはレイヤードアーキテクチャを採用しています。

Presentation Layer (Controller)
↓
Application Layer (Service)
↓
Infrastructure Layer (Repository)
↓
Domain Layer (Entity)

- Controller は外部I/Fの受付に専念
- Service はビジネスロジックを管理
- Repository は永続化責務を担当
- Domain(Entity) は業務モデルを表現

DTOは外部とのデータ契約を表すモデルとして独立パッケージに配置しています。

---

## Package Structure

```text
com.example.todo
├── controller
├── service
├── repository
├── domain
└─dto 
```

---

## Current Status

- [x] MVC構成の確立
- [x] Thymeleafによる画面表示
- [ ] Entity実装
- [ ] Repository実装
- [ ] Service実装
- [ ] CRUD機能
- [ ] DTO導入
- [ ] REST API化

---

## Future Improvements

- REST APIへの拡張
- フロントエンド分離（React想定）
- Docker対応
- PostgreSQL対応
- 認証・認可機能追加
- CI/CD構築

---

## Design Policy

- レイヤー責務を明確に分離する
- フレームワーク依存を局所化する
- 将来拡張を想定したパッケージ設計を行う
- 実装と設計ドキュメントを並行して更新する
