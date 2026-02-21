# Architecture Overview

## 1. 採用アーキテクチャ

本アプリケーションは **レイヤードアーキテクチャ（Layered Architecture）** を採用している。

### ■ レイヤードアーキテクチャとは

責務ごとに層（Layer）を分離し、  
依存関係を「上位 → 下位」に一方向へ制御する設計様式。

### 目的

- 関心の分離（Separation of Concerns）
- 変更容易性の向上
- テスト容易性の確保
- 保守性の向上

---

## 2. レイヤー構成

```text
Presentation Layer
├── Controller（Spring MVC）
└── DTO（Request / Response）

Application Layer
└── Service

Domain Layer
└── Entity

Infrastructure Layer
└── Repository（Spring Data JPA）
```

---

## 3. MVCとの関係

MVCはPresentation層における設計パターンである。

Spring MVCでは以下のように位置付けられる：

- Controller → Presentation層
- View（Thymeleaf）→ Presentation層
- Model → DTOまたはEntity

本アプリケーションでは、

- 画面入出力にはDTOを使用
- 永続化対象にはEntityを使用

と役割を分離している。

---

## 4. 各レイヤーの依存関係

```text
Presentation
   ↓
Application
   ↓
+-------------------+
|      Domain       |
|      Entity       |
+-------------------+
   ↑           ↑
Repository ----+
   ↓
Database


```

本設計では依存方向を上位 → 下位に限定し、DI（依存性注入）を利用することで疎結合を実現している。

※ EntityはServiceとRepository両方から参照される。

---

## 5. Entity / DTOの位置付け

### ■ Entity（Domain Layer）

- DBテーブルとマッピングされる永続化オブジェクト
- 業務データの状態を保持する
- JPAアノテーションを保持

### ■ DTO（Presentation / Application）

- 外部I/F用データ構造
- Controller ↔ Service間のデータ受け渡しに利用
- API化・バッチ化・メッセージ連携を想定した拡張ポイント

Entityを外部公開しない設計とすることで、
将来的なI/F変更耐性を確保している。

---

## 6. 実行環境構成

### ■ 現在の構成（ローカル開発環境）
```text
Browser
↓
Spring Boot Application
└── Embedded Tomcat
↓
H2 Database
```

Spring Bootは組み込みTomcatを内包しているため、
外部Webサーバ（Apache等）は利用していない。

---

### ■ 将来想定（Docker化）
```text
Docker
├── App Container
│   └── Spring Boot (Embedded Tomcat)
└── DB Container
    └── PostgreSQL
```

アプリケーション実行環境（JDK含む）をコンテナ化し、
環境差異の排除とデプロイ容易性を向上させる。

---

## 7. 設計ポリシー

- Controllerに業務ロジックを書かない
- Serviceをユースケース単位で設計する
- Repositoryは永続化処理のみに責務を限定する
- EntityとDTOを明確に分離する
- 依存方向を厳守する
- 各レイヤーは直接下位レイヤーにのみ依存する 
- 横断的関心（例：ログ、例外処理）はフレームワーク機能を利用する

---

## 8. 将来拡張想定

- REST API化
- SPA化（フロント分離）
- バッチ処理追加
- メッセージキュー連携
- RDBMS切り替え（H2 → PostgreSQL）
- Docker / CI/CD対応

