CREATE TABLE customer (
      customer_id SERIAL PRIMARY KEY,
      name VARCHAR(255) NOT NULL,
      email VARCHAR(255) NOT NULL UNIQUE,
      password VARCHAR(255) NOT NULL,
      role VARCHAR(255) NOT NULL,
      study_area VARCHAR(255),
      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
      updated_at TIMESTAMP
);

CREATE TABLE article (
     article_id SERIAL PRIMARY KEY,
     sender_id INT NOT NULL,
     title VARCHAR(255) NOT NULL,
     content TEXT NOT NULL,
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP,
     FOREIGN KEY (sender_id) REFERENCES customer(customer_id) ON DELETE CASCADE
);

CREATE TABLE key_word (
      key_word_id SERIAL PRIMARY KEY,
      article_id INT NOT NULL,
      content VARCHAR(255) NOT NULL,
      created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
      FOREIGN KEY (article_id) REFERENCES article(article_id) ON DELETE CASCADE
);

CREATE TABLE attachment (
    attachment_id SERIAL PRIMARY KEY,
    article_id INT NOT NULL,
    link VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (article_id) REFERENCES article(article_id) ON DELETE CASCADE
);

CREATE TABLE comment (
     comment_id SERIAL PRIMARY KEY,
     article_id INT NOT NULL,
     customer_id INT NOT NULL,
     content VARCHAR(255) NOT NULL,
     created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
     updated_at TIMESTAMP,
     FOREIGN KEY (article_id) REFERENCES article(article_id) ON DELETE CASCADE,
     FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE
);

INSERT INTO customer (name, email, password, role, study_area, created_at, updated_at)
VALUES
    ('Alice Johnson', 'alice.johnson@example.com', 'password123', 'Writer', 'Software Engineering', '2025-02-01', null),
    ('Bob Smith', 'bob.smith@example.com', 'password456', 'Revisor', 'Cybersecurity', '2025-02-02', '2025-02-02'),
    ('Charlie Davis', 'charlie.davis@example.com', 'password789', 'Guest', 'Data Science', '2025-02-03', null),
    ('David Miller', 'david.miller@example.com', 'password101', 'Writer', 'Data Engineering', '2025-02-04', null),
    ('Eva Green', 'eva.green@example.com', 'password102', 'Revisor', 'Cloud Computing', '2025-02-05', '2025-02-05'),
    ('Frank White', 'frank.white@example.com', 'password103', 'Guest', 'Machine Learning', '2025-02-06', null),
    ('Grace Lee', 'grace.lee@example.com', 'password104', 'Writer', 'DevOps', '2025-02-07', '2025-02-07'),
    ('Helen Black', 'helen.black@example.com', 'password105', 'Revisor', 'AI', '2025-02-08', '2025-02-08');

INSERT INTO article (sender_id, title, content, created_at, updated_at)
VALUES
    (7, 'Introduction to Cloud Computing', 'Cloud computing allows businesses to scale and save costs. It is a model that delivers computing services over the internet.', '2025-02-01', '2025-02-01'),
    (7, 'Understanding Blockchain Technology', 'Blockchain is a decentralized digital ledger technology. It enables secure transactions and is the backbone of cryptocurrencies.', '2025-02-02', '2025-02-02'),
    (4, 'AI and Machine Learning in Data Science', 'Artificial Intelligence (AI) and Machine Learning (ML) are revolutionizing the field of Data Science, providing predictive analytics and insights.', '2025-02-03', '2025-02-03'),
    (1, 'Cybersecurity Best Practices', 'Cybersecurity is essential for protecting sensitive information in the digital world. It includes practices such as encryption, firewalls, and secure coding.', '2025-02-04', '2025-02-04'),
    (7, 'Introduction to DevOps', 'DevOps integrates software development and IT operations, aiming to shorten the development life cycle and improve software quality through automation.', '2025-02-05', '2025-02-05'),
    (7, 'Blockchain in Healthcare', 'Blockchain has the potential to revolutionize healthcare by ensuring the secure and transparent exchange of medical records and patient data.', '2025-02-06', '2025-02-06'),
    (4, 'The Future of Quantum Computing', 'Quantum computing is a new paradigm in computing that promises to solve problems that are intractable for classical computers.', '2025-02-07', '2025-02-07'),
    (1, 'Web Development Trends in 2025', 'Web development is evolving rapidly with the rise of frameworks like React, Angular, and Vue.js. In 2025, we expect to see further advancements in web applications.', '2025-02-08', '2025-02-08'),
    (4, 'Big Data and Its Impact on Business', 'Big Data refers to large, complex data sets that can be analyzed for insights. In business, Big Data is transforming industries by enabling data-driven decision-making.', '2025-02-09', '2025-02-09'),
    (1, 'IoT and Smart Cities', 'The Internet of Things (IoT) is driving the creation of smart cities. Sensors and devices are connected to the internet, providing data to improve urban living.', '2025-02-10', '2025-02-10');

INSERT INTO key_word (article_id, content, created_at)
VALUES
    (1, 'Cloud Computing', '2025-02-01'),
    (1, 'Virtualization', '2025-02-01'),
    (2, 'Blockchain', '2025-02-02'),
    (2, 'Cryptocurrency', '2025-02-02'),
    (3, 'Artificial Intelligence', '2025-02-03'),
    (3, 'Machine Learning', '2025-02-03'),
    (4, 'Cybersecurity', '2025-02-04'),
    (4, 'Data Protection', '2025-02-04'),
    (5, 'DevOps', '2025-02-05'),
    (5, 'Automation', '2025-02-05'),
    (6, 'Healthcare', '2025-02-06'),
    (6, 'Blockchain', '2025-02-06'),
    (7, 'Quantum Computing', '2025-02-07'),
    (7, 'Quantum Algorithms', '2025-02-07'),
    (8, 'Web Development', '2025-02-08'),
    (8, 'Frameworks', '2025-02-08'),
    (9, 'Big Data', '2025-02-09'),
    (9, 'Business Analytics', '2025-02-09'),
    (10, 'Internet of Things', '2025-02-10'),
    (10, 'Smart Cities', '2025-02-10');

INSERT INTO attachment (article_id, link, description, created_at)
VALUES
    (1, 'https://example.com/cloud-computing-intro', 'Introductory article on cloud computing', '2025-02-01'),
    (2, 'https://example.com/blockchain-tech', 'Deep dive into blockchain technology', '2025-02-02'),
    (3, 'https://example.com/ai-and-machine-learning', 'Explains the role of AI in data science', '2025-02-03'),
    (4, 'https://example.com/cybersecurity-best-practices', 'Best practices for securing your data', '2025-02-04'),
    (5, 'https://example.com/devops-introduction', 'A guide to understanding DevOps', '2025-02-05'),
    (6, 'https://example.com/blockchain-healthcare', 'The application of blockchain in healthcare', '2025-02-06'),
    (7, 'https://example.com/quantum-computing-future', 'Insights into the future of quantum computing', '2025-02-07'),
    (8, 'https://example.com/web-dev-trends', 'Latest trends in web development', '2025-02-08'),
    (9, 'https://example.com/big-data-business', 'How Big Data impacts businesses', '2025-02-09'),
    (10, 'https://example.com/iot-smart-cities', 'The role of IoT in smart cities', '2025-02-10');

INSERT INTO comment (article_id, customer_id, content, created_at)
VALUES
    (1, 1, 'Great article! Very informative on cloud computing.', '2025-02-01'),
    (1, 2, 'Clear and concise explanation. Thanks for sharing!', '2025-02-01'),
    (2, 2, 'Blockchain is a game changer for many industries.', '2025-02-02'),
    (2, 3, 'Interesting read, looking forward to more on this topic.', '2025-02-02'),
    (3, 3, 'AI and ML are definitely changing the way we work with data.', '2025-02-03'),
    (3, 1, 'Good insights on AI and Machine Learning.', '2025-02-03'),
    (4, 1, 'Very practical advice on cybersecurity. Highly recommended.', '2025-02-04'),
    (4, 2, 'Great tips for improving cybersecurity in organizations.', '2025-02-04'),
    (5, 2, 'DevOps is the future! Excited about the possibilities.', '2025-02-05'),
    (5, 3, 'Nice intro to DevOps, will share with my team.', '2025-02-05'),
    (6, 1, 'Blockchain could transform healthcare, definitely worth exploring.', '2025-02-06'),
    (6, 3, 'This article opened my eyes to blockchain in healthcare.', '2025-02-06'),
    (7, 2, 'Quantum computing is going to be huge in the future.', '2025-02-07'),
    (7, 1, 'Incredible potential for solving complex problems.', '2025-02-07'),
    (8, 1, 'Web development is evolving fast, and 2025 looks promising.', '2025-02-08'),
    (8, 2, 'Definitely keeping an eye on web dev trends this year.', '2025-02-08'),
    (9, 3, 'Big Data is revolutionizing industries. Very exciting times ahead!', '2025-02-09'),
    (9, 1, 'Big Data has massive potential to drive business decisions.', '2025-02-09'),
    (10, 2, 'IoT will make cities smarter and more efficient.', '2025-02-10'),
    (10, 3, 'Smart cities are the future, and IoT is the backbone of this evolution.', '2025-02-10');
