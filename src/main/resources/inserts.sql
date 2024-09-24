INSERT INTO "content" (id, "name", genre, "type", num_views, rate)
VALUES
    ('345a792a-08b7-4fc9-8cd0-9e7be0281e49', 'Inception', 'Sci-Fi', 'MOVIE', 1, 4.2),
    ('762e74e2-2699-4ca2-9aff-1a188d933da3', 'Breaking Bad', 'Drama', 'SERIE', 1, 4.5),
    ('5e3b8005-966b-4ee6-91d0-0f731cd96f10', 'Avatar: The Last Airbender', 'Animation', 'SERIE', 1, 3.1);


INSERT INTO "users" (id, nickname, email, password)
VALUES
    ('0d07b58b-b823-4d57-ad31-3c1f63a02667', 'john_doe', 'john.doe@example.com', 'securePassword123'),
    ('5b32d54e-1112-4719-804b-cc8968beb22f', 'jane_smith', 'jane.smith@example.com', 'anotherSecurePass');


INSERT INTO user_content_view (id, content_id, user_id)
VALUES
    ('660e8400-e29b-41d4-a716-446655440000', '345a792a-08b7-4fc9-8cd0-9e7be0281e49', '0d07b58b-b823-4d57-ad31-3c1f63a02667');


INSERT INTO content_rate (id, content_id, rate, user_id)
VALUES
    ('559f1e7c-39f3-47e9-abaf-83cefb334daa', '345a792a-08b7-4fc9-8cd0-9e7be0281e49', 4.2, '0d07b58b-b823-4d57-ad31-3c1f63a02667'),
    ('4f1efdf2-3872-4cf1-9b70-9636d35751ff', '762e74e2-2699-4ca2-9aff-1a188d933da3', 4.5, '0d07b58b-b823-4d57-ad31-3c1f63a02667'),
    ('0fb1404d-ecc8-40c3-aa77-43466b428069', '5e3b8005-966b-4ee6-91d0-0f731cd96f10', 3.1, '0d07b58b-b823-4d57-ad31-3c1f63a02667');