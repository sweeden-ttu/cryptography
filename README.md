# Cryptography Exam LaTeX Audit and Verified Revision Pack

## Scope and assumptions

This audit and revision pack is grounded in the materials currently available in the chat: the sample exam PDF (Exam 1), a separate PDF of the \(GF(2^8)\) multiplicative inverse table, and a short “sample exam question” excerpt. fileciteturn1file1 fileciteturn1file0 fileciteturn1file2

No original user-authored “.tex” sources were provided as files in this thread; accordingly, the “original vs. revised” comparison and commentary are based on (i) the sample exam’s topic requirements (what the sheet must support) and (ii) the previously supplied LaTeX snippet you pasted earlier in the chat as the apparent baseline structure. fileciteturn1file1

The two requested revised deliverables were produced exactly to the layout constraints you specified: landscape orientation, dense small font, condensed margins, minimal paragraph/list spacing, and no bullet decorations; additionally, all cryptocurrency-specific material and any ChaCha-related content were excluded by design. (No primary-source citation needed; this is an editorial constraint applied to the output.)

## What the supplied exam materials imply about required coverage

The sample exam explicitly targets a tight cluster of concepts and computation skills:

The “Introduction and Classical Ciphers” portion asks students to distinguish computational vs. unconditional security and to describe an attack line that “essentially breaks the Hill cipher,” plus an evaluation using Kerckhoffs’ principle (i.e., why “secret algorithm ⇒ secure” fails). fileciteturn1file1 This establishes that the sheet should not merely list cipher names; it must (a) state definitions cleanly and (b) include the key algebra/linearity insight for Hill (known-plaintext turning into solvable linear equations). citeturn5search6turn3search14

The OTP section reproduces a Bayes/total-probability proof outline (attributed to Shannon in the exam text) and then asks for explanations of labeled steps—so a compact “proof skeleton” is required: Bayes’ theorem, expansion of \(\Pr[C=c]\), and the OTP step \(\Pr[C=c\mid M=m]=\Pr[K=m\oplus c]\) with uniform key. fileciteturn1file1 This aligns with the classic definition of “perfect secrecy” and the OTP key-length necessity results in entity["people","Claude Shannon","information theory"]’s 1949 paper. citeturn3search0

The exam then tests OTP malleability and a crib-dragging style observation (key reuse → XOR cancels), implying the cheat sheet must highlight that OTP provides confidentiality only (perfect secrecy) but not integrity, and that reusing a one-time key fundamentally collapses security. fileciteturn1file1 citeturn3search0turn3search14

The “Block Cipher Concepts” section asks for the number of mappings/keys supported by the ideal block cipher (IBC) for block size \(n\), and why it’s impractical, then presents a linear “matrix over GF(2)” compromise and asks what it fixes (compact key/implementation vs. enumeration of all permutations) and what it breaks (linearity ⇒ solvable). fileciteturn1file1 This corresponds to standard “ideal permutation / ideal cipher” modeling treatment in modern cryptography texts such as Boneh–Shoup. citeturn3search3turn3search14

The “Abstract Algebra” section tests: (i) verifying that \((\{0,1\},\oplus)\) forms an Abelian group by checking axioms, (ii) multiplying two polynomials in \(GF(2^8)\) and reducing modulo \(p(x)=x^8+x^4+x^3+x+1\), and (iii) using a provided multiplicative inversion table to invert a specified byte-polynomial and express the final answer as a polynomial. fileciteturn1file1 The reduction polynomial and the field construction match the AES field definition in NIST’s AES standard. citeturn0search4 The inversion table shown in the exam appendix matches the “AES S-box inverse” lookup table format (16×16 by hex nibbles). fileciteturn1file1 fileciteturn1file0 citeturn0search4

```mermaid
flowchart TD
  A[Security notions] --> B[Perfect secrecy definition]
  B --> C[OTP proof steps: Bayes + total probability]
  C --> D[OTP malleability + key reuse hazards]
  A --> E[Kerckhoffs principle]
  E --> F[Why secret algorithm ≠ secure]
  G[Classical ciphers] --> H[Hill cipher linearity]
  H --> I[Known-plaintext ⇒ solve linear equations]
  J[Ideal block cipher model] --> K[(2^n)! permutations]
  J --> L[Impractical table size: n·2^n bits]
  M[GF(2^8) arithmetic] --> N[Reduce mod p(x)=x^8+x^4+x^3+x+1]
  N --> O[Inverse lookup table usage]
  O --> P[Convert inverse byte ⇄ polynomial]
```

## Verification against primary and official sources

### Symmetric primitives and modes

The AES-related algebra in your materials—representing bytes as degree-<8 polynomials over GF(2), reducing multiplication mod \(p(x)=x^8+x^4+x^3+x+1\) (hex 0x11B), and the S-box being a multiplicative inverse in \(GF(2^8)\) followed by an affine transform—is directly specified in the AES standard (FIPS 197, updated). citeturn0search4

For DES and Triple-DES: “56-bit effective key” (DES’s key bits excluding parity) and a 64-bit block size are specified in FIPS 46-3. citeturn1search0 Triple-DES/TDEA usage and constraints belong in a cheat sheet mainly as “legacy/transition primitive” context (where permitted), and NIST SP 800-67 Rev. 2 is the modern NIST recommendation for TDEA. citeturn1search1turn1search5

For modes of operation: NIST SP 800-38A defines ECB/CBC/CFB/OFB/CTR and is the canonical reference to verify statements like “ECB leaks patterns,” “CBC requires an IV,” and “CTR requires unique nonce/counter combinations.” citeturn1search6 Authenticated encryption modes: NIST SP 800-38D specifies GCM/GMAC (AEAD) and formalizes why nonce reuse under the same key breaks security assurances; SP 800-38C specifies CCM (CTR + CBC-MAC) as an AEAD construction. citeturn1search7turn4search1 For a protocol-facing AEAD interface and explicit “nonce reuse is catastrophic” guidance usable in a study sheet, RFC 5116 is a strong primary reference. citeturn4search0turn4search4

### Hashes, MACs, and integrity

NIST FIPS 180-4 standardizes SHA-1/SHA-2 family details and is the correct source to cite for structural statements about SHA-256 being a standardized secure hash algorithm and for defining digest lengths and operational primitives. citeturn0search1

For HMAC, the primary specification is RFC 2104; it defines HMAC’s construction and its purpose as a keyed-hash message authentication mechanism. citeturn0search2turn0search6 For a block-cipher MAC in a standards context, NIST SP 800-38B specifies CMAC and is the authoritative citation. citeturn4search2turn4search6

### Public-key cryptography and signatures

For RSA, the original 1978 Rivest–Shamir–Adleman paper is the appropriate primary reference for the primitive’s construction and its “public-key cryptosystem” framing. citeturn2search0 Diffie–Hellman is best verified by the original 1976 “New Directions in Cryptography” paper (which introduces the public-key idea and key exchange). citeturn2search1

For elliptic-curve cryptography (ECC), Neal Koblitz’s 1987 paper is a standard primary reference for ECC-based public-key cryptosystems over finite fields. citeturn2search2

For ECDSA, NIST FIPS 186-5 is the authoritative standard reference (including the signing/verification algorithm family and security-strength framing). citeturn4search3turn4search15

### Post-quantum primitives

For post-quantum cryptography in a “study sheet” context, the most stable primary sources are NIST’s finalized FIPS documents and NIST’s announcements: FIPS 203 specifies ML-KEM (a KEM) including its parameter sets; NIST’s PQC news posts summarize standardized signature standards (FIPS 204 and 205) and their algorithmic lineages. citeturn0search7turn0search13turn0search3

## Critique of the baseline LaTeX content and common correctness pitfalls

This section focuses on correctness/pedagogical issues that commonly appear in dense “exam cheat sheets,” including issues visible in the earlier pasted LaTeX snippet and issues implied by the sample exam’s required skills.

A frequent precision bug is writing the “ideal block cipher keyspace” as something like `2^n!` or `2^n!` without parentheses; it should be \((2^n)!\), i.e., the factorial of the number of possible \(n\)-bit blocks, because an IBC key selects a permutation on \(\{0,1\}^n\). fileciteturn1file1 citeturn3search3turn3search14 In the revised documents, this is forced into the unambiguous \((2^n)!\) form.

Another recurring issue is mixing the AES field polynomial mechanics (“reduce modulo \(p(x)=x^8+x^4+x^3+x+1\)”) with generic “mod arithmetic” phrasing that can confuse students into thinking \(\mathbb{Z}_{2^8}\) or \(\mathbb{Z}_8\) is involved. The correct construction for AES uses polynomials over GF(2) reduced modulo an irreducible degree-8 polynomial; that is exactly how FIPS 197 defines the byte field arithmetic. citeturn0search4 The sample exam explicitly calls this out by requiring reduction under that polynomial. fileciteturn1file1

For OTP, the most common pedagogical error is to conflate “perfect secrecy” with “tamper-proof.” The exam explicitly tests malleability and crib-dragging (key reuse), which depend on a clear statement that OTP gives information-theoretic confidentiality only, not integrity. fileciteturn1file1 Shannon’s definition of perfect secrecy is about posterior distributions of messages given ciphertext, not about preventing modification. citeturn3search0 The revised sheets include (i) the perfect-secrecy condition and (ii) a one-line malleability transformation \(C' = C\oplus \Delta \Rightarrow M' = M\oplus \Delta\), matching the exam’s intent. fileciteturn1file1

For Hill cipher coverage, a common “too-vague” line is “known plaintext breaks it” without the linear algebra reason. Because the Hill cipher is linear, enough plaintext/ciphertext blocks yield a solvable linear system for the key matrix (or enable directly computing \(K = CP^{-1}\) when arranged appropriately). citeturn5search6 The exam asks for the “line of attack,” so the revised text makes the linearity→system-solving path explicit concisely. fileciteturn1file1

Finally, a correctness/scope problem in many cheat sheets is including domain-specific protocol or application notes (cryptocurrency mining, wallet signature rules, etc.) that are not implied by the exam’s content objectives. The revision pack is intentionally protocol-agnostic except where standards define required usage constraints (e.g., nonce uniqueness for GCM/AEAD), which are universally applicable. citeturn4search4turn1search7

```mermaid
flowchart LR
  P[Polynomial h(x) in GF(2^8)] --> B[Bits b7..b0]
  B --> H[Hex byte xy]
  H --> T[Inverse table lookup: row x, col y]
  T --> I[Inverse byte]
  I --> Q[Convert back to polynomial]
  Q --> S[AES S-box step: inverse then affine]
```

## Revised deliverables and file bundle

### Document A

Document A is a two-page, landscape, **two-column** dense study sheet with expanded “why this matters” micro-explanations, focused on what Exam 1 actually tests (OTP proof/malleability, IBC counting and linear compromise critique, Abelian group axioms, and \(GF(2^8)\) reduction mechanics), while still including compact coverage of DES/3DES/AES, modes, hashes/MACs/AEAD, RSA/DH/ECC, and a minimal PQC snapshot. fileciteturn1file1 citeturn0search4turn1search6turn0search1turn2search1turn0search7

- Annotated LaTeX (with audit comments): [Download](sandbox:/mnt/data/crypto_exam_pack_v3/DocA_study_sheet_annotated.tex)  
- Clean v2 LaTeX: [Download](sandbox:/mnt/data/crypto_exam_pack_v3/DocA_study_sheet_v2.tex)  
- Compiled PDF: [Download](sandbox:/mnt/data/crypto_exam_pack_v3/DocA_study_sheet_v2.pdf)

### Document B

Document B is a single-page, landscape, **two-column** sheet: left column contains a grouped **58-question micro-quiz** with slightly more explanatory short answers (conceptual/method-level), while the right column contains the full \(GF(2^8)\) multiplicative inverse table followed **by the table-usage instructions beneath it**, matching your placement requirement. The inverse table values follow the provided PDF and the exam appendix. fileciteturn1file0 fileciteturn1file1 citeturn0search4

- Annotated LaTeX (with audit comments): [Download](sandbox:/mnt/data/crypto_exam_pack_v3/DocB_quiz_plus_inverse_table_annotated.tex)  
- Clean v2 LaTeX: [Download](sandbox:/mnt/data/crypto_exam_pack_v3/DocB_quiz_plus_inverse_table_v2.tex)  
- Compiled PDF: [Download](sandbox:/mnt/data/crypto_exam_pack_v3/DocB_quiz_plus_inverse_table_v2.pdf)

## Diff-style change log and verification status table

The table below summarizes the high-impact revisions made relative to the earlier pasted baseline approach (“giant lookup-table cheat sheet + inverse table page”), constrained by the sample exam’s actual skills and verified against primary sources.

| Area | Baseline risk pattern | v2 revision | Verification status |
|---|---|---|---|
| IBC key/mapping count | Ambiguous notation like `2^n!` and missing “permutation” explanation | Uses \((2^n)!\) explicitly and adds one-line modeling interpretation | Matches ideal-permutation modeling in modern texts citeturn3search3turn3search14 |
| OTP perfect secrecy | Often only formula, not proof skeleton; sometimes conflates secrecy with integrity | Includes both definition and Bayes/total-probability skeleton; explicitly flags malleability | Matches Shannon’s 1949 definition and standard equivalences citeturn3search0turn3search14 |
| OTP misuse | Key-reuse warning sometimes missing or vague | Adds explicit “reuse ⇒ XOR cancels key” and “crib dragging” cue | Matches standard OTP reasoning and exam objectives fileciteturn1file1 citeturn3search0 |
| Hill cipher “break” | “Known plaintext breaks it” without linear algebra line | States linearity → solvable system / compute \(K\) when blocks invertible | Matches standard Hill cryptanalysis treatments citeturn5search6 |
| \(GF(2^8)\) arithmetic | Risk of mixing \(\mathbb{Z}_{2^8}\) vs field; reduction polynomial variants | Uses AES \(p(x)=x^8+x^4+x^3+x+1\) and “poly-over-GF(2) then reduce” phrasing | Matches FIPS 197 and sample exam polynomial fileciteturn1file1 citeturn0search4 |
| Inverse table workflow | Sometimes gives table without “poly↔byte” conversion steps | Document B places conversion/lookup steps directly beneath the table | Matches exam requirement (“answer must be polynomial”) fileciteturn1file1 fileciteturn1file0 |
| Modes + AEAD | Often lists modes but omits the “what breaks if you reuse IV/nonce” rule | Adds nonce/IV uniqueness constraints; AEAD callout; GCM/CCM summarized | Matches NIST mode specs + RFC 5116 nonce warning citeturn1search6turn1search7turn4search4turn4search1 |
| Modern primitives breadth | Random application-specific content can crowd out exam-relevant methods | Keeps protocol-agnostic, standards-rooted “what it is / what can go wrong” | Standards-backed references included (FIPS/RFC) citeturn0search1turn0search2turn4search2 |
| Post-quantum snapshot | Can drift into speculative/dated algorithm lists | Anchored to NIST finalized standards (ML-KEM, ML-DSA, SLH-DSA) | NIST FIPS + NIST announcements citeturn0search7turn0search13turn0search3 |

## Academic integrity and safe-use checklist

Because the sample exam includes explicit computational tasks (e.g., a specific OTP bitstring malleability demonstration and a specific \(GF(2^8)\) inversion), a “reverse-engineered answer key” would cross an integrity line if it reproduces solved outputs for those exact instances. fileciteturn1file1 The revision strategy used here keeps materials at the level of: definitions, proof skeletons, transformation rules, and workflows (e.g., polynomial→byte→table→byte→polynomial), which is consistent with legitimate study aids rather than a keyed solution set. fileciteturn1file1 citeturn3search0turn0search4

The “quiz” items in Document B are intentionally conceptual and grouped by topic (security notions, classical ciphers, OTP/IBC/algebra, modern primitives, PQC) and do not copy the exam’s numeric instances wholesale; this is aligned with the exam’s stated conditions focusing on understanding and method rather than reproducing hidden answers. fileciteturn1file1

Finally, Kerckhoffs’ principle is treated as a general evaluation lens (“assume the adversary knows the system; secrecy resides in the key”), which is exactly the kind of reasoning the exam requests—and is consistent with modern cryptography pedagogy in standard texts and Shannon-style threat formulation. fileciteturn1file1 citeturn3search0turn3search14turn3search3
