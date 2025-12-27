# mtr-backend

mtr-backend/
src/
main/
java/com/yourorg/mtrmap/
MtrBackendApplication.java
config/ # 設定類（CORS, Security, Jackson, etc）
controller/ # REST API の入口
service/ # 業務ロジック
repository/ # DB アクセス（JPA Repository）
domain/ # ドメイン（Entity, ValueObject）
entity/
value/
dto/ # リクエスト/レスポンス DTO
exception/ # 例外＆ハンドリング
util/ # 共通ユーティリティ（必要最小限）
resources/
application.yml
application-local.yml
application-docker.yml
db/migration/ # Flyway 使うならここ
test/
java/
com/yourorg/mtrmap/
controller/
service/
repository/
