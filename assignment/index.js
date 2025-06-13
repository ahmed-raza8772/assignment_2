const express = require('express');
const cors = require('cors');
const pool = require('./db');
require('dotenv').config();

const app = express();

app.use(cors());
app.use(express.json());

// Teacher
app.get('/teacher', async (req, res) => {
  try {
    const result = await pool.query('SELECT * FROM Teacher');
    res.json(result.rows);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Student
app.get('/student', async (req, res) => {
  try {
    const result = await pool.query('SELECT * FROM Student');
    res.json(result.rows);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Course
app.get('/course', async (req, res) => {
  try {
    const result = await pool.query('SELECT * FROM Course');
    res.json(result.rows);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

// Enrollment
app.get('/enrollment', async (req, res) => {
  try {
    const result = await pool.query('SELECT * FROM Enrollment');
    res.json(result.rows);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

const PORT = process.env.PORT || 5060;
app.get('/', (req, res) => {
  res.send('Server is working!');
});

app.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});