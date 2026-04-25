# The Complete Guide to Secret Hygiene for Java and Cloud-Native Engineers

[![Conference](https://img.shields.io/badge/Talk-Spring_I/O_2026-green)](https://2026.springio.net/speakers/martin-ladecky/)
[![Presentation](https://img.shields.io/badge/Slides-PDF-orange)](#-resources)
[![License: Ask author](https://img.shields.io/badge/License-Ask_author-yellow.svg)](#-license)

> *"It’s just a local config."* > *"I’ll delete the history later."*

In the fast-paced world of Cloud-Native Java, these common phrases are the precursors to security disasters. This repository contains the code samples, forensic artifacts, and solution toolkit from my session at **Spring I/O 2026**.

## 🔍 Overview

Our tools are designed for convenience, but that convenience often creates "secret leaks" across the entire supply chain. This repository serves as a **forensic deep dive** into how credentials escape into the wild and provides a practical roadmap to securing them.

### We perform "Live Autopsies" on:
* **The Developer Desk:** Plain-text risks in Maven `settings.xml`.
* **The Source:** Why `git rm` fails to protect your history and how to scrub it.
* **The Image:** Using tools like `dive` to uncover passwords in "deleted" Docker layers.
* **The Pipeline:** How CI/CD logs in Jenkins or TeamCity can betray your credentials.
* **The Runtime:** Moving from hardcoded configs to modern HashiCorp Vault injection.

---

## 📂 Repository Contents

This repo contains the "evidence" used during the live demonstrations:

| File | Description |
| :--- | :--- |
| `actuator.response.json` | **Vulnerable:** Raw output of a Spring Boot Actuator `/env` endpoint leaking secrets. |
| `acuator.response_sanitized.json` | **Fixed:** The same endpoint with proper `additional-keys-to-sanitize` configuration. |
| `heapdump.hprof` | A sample memory dump used to show how secrets can be extracted from RAM. |
| `pom-local-repo.xml` | Example of risky Maven repository configurations. |
| `src/` | Java source code demonstrating secure vs. insecure secret handling. |
| `presentation.pdf` | The full slide deck from the Spring I/O 2026 session. |

---

## 🛠 The Toolkit

You will find examples in this repo on how to implement:
1.  **Pre-commit Hooks:** Prevent secrets from ever leaving your machine.
2.  **Maven Encryption:** Using `settings-security.xml` to protect local credentials.
3.  **Spring Boot Sanitization:** Configuring Actuator to mask sensitive metadata.
4.  **Secret Injection:** Moving from hardcoded `server.xml` to dynamic Vault injection.

---

## 🚀 Getting Started

To explore the forensic artifacts:

1. **Analyze the Leak:**
   Compare `actuator.response.json` and `acuator.response_sanitized.json` to see how Spring Boot can be configured to protect environment variables.

2. **Run the Demo App:**
   ```bash
   ./mvnw spring-boot:run

## 📜 License

Ask author. Please contact the author to approve any usage of this work.