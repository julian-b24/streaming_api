INSERT INTO "content" (id, "name", genre, "type", num_views, rate)
VALUES
    ('550e8400-e29b-41d4-a716-446655440000', 'Inception', 'Sci-Fi', 'MOVIE', 1, 8.8),
    ('550e8400-e29b-41d4-a716-446655440001', 'Breaking Bad', 'Drama', 'SERIE', 1, 9.5),
    ('550e8400-e29b-41d4-a716-446655440002', 'Avatar: The Last Airbender', 'Animation', 'SERIE', 1, 9.2);


INSERT INTO content_rate (id, content_id, rate)
VALUES
    ('550e8400-e29b-41d4-a716-446655440003', '550e8400-e29b-41d4-a716-446655440000', 8.8),
    ('550e8400-e29b-41d4-a716-446655440004', '550e8400-e29b-41d4-a716-446655440001', 9.5),
    ('550e8400-e29b-41d4-a716-446655440005', '550e8400-e29b-41d4-a716-446655440002', 9.2);