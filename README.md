# docker コマンド

echo 'export PATH="/Applications/Docker.app/Contents/Resources/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc

# ソース修正時

docker compose up -d --build api

# MySQL 接続

echo 'export PATH="/usr/local/opt/mysql-client/bin:$PATH"' >> ~/.zshrc
source ~/.zshrc
mysql -h 127.0.0.1 -P 3306 -u root -p --default-character-set=utf8mb4

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
