# タスク管理API

Spring Boot を学習するために作成したシンプルな タスク管理APIです。

## 主な機能
- タスクの登録
- タスクの表示
- タスクの更新
- タスクの削除

## 使用技術
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (開発用)
- Lombok

## APIエンドポイント
| メソッド | パス | 内容 |
|-----------|------|------|
| GET | /api/tasks | タスク一覧取得 |
| POST | /api/tasks | 新規作成 |
| GET | /api/tasks/{id} | タスク詳細 |
| PATCH | /api/tasks/{id} | 編集 |
| DELETE | /api/tasks/{id} | 削除 |
